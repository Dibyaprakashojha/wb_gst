package com.uneecops.common.ServiceImplementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uneecops.common.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImp.class);

    @Value("${thirdparty.api.auth.url}")
    private String authUrl;

    @Value("${thirdparty.api.clientid}")
    private String clientId;

    @Value("${thirdparty.api.clientsecret}")
    private String clientSecret;

    @Value("${thirdparty.api.statecd}")
    private String stateCd;

    @Value("${thirdparty.api.username}")
    private String username;

    @Value("${thirdparty.api.password}")
    private String password;

    @Value("${thirdparty.api.appkey}")
    private String appKey;
    
    private String token;

    @Override
    public String authenticate() {
        RestTemplate restTemplate = new RestTemplate(); // Setup headers

        HttpHeaders headers = new HttpHeaders();
        headers.set("clientid", clientId);
        headers.set("client-secret", clientSecret);
        headers.set("state-cd", stateCd);
        headers.set("Content-Type", "application/json");

        // Prepare request body
        String requestBody = "{\n" + "  \"action\": \"ACCESSTOKEN\",\n" + "  \"username\": \"" + username + "\",\n"
                + "  \"password\": \"" + password + "\",\n" + "  \"app_key\": \"" + appKey + "\"\n" + "}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            logger.info("Sending authentication request to: {}", authUrl);
            ResponseEntity<String> response = restTemplate.exchange(authUrl, HttpMethod.POST, requestEntity,
                    String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                // Extract the auth token from the response body
                token = extractAuthToken(response.getBody());
                return token;
            } else {
                logger.error("Authentication failed with status: {} and response: {}", response.getStatusCode(), response.getBody());
                throw new RuntimeException("Authentication failed: " + response.getBody());
            }
        } catch (Exception e) {
            logger.error("Authentication failed due to an error: {}", e.getMessage());
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    // Extract the auth token from the response JSON
    public String extractAuthToken(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);

            // Check if the response contains "auth_token"
            JsonNode authTokenNode = rootNode.path("auth_token");
            if (!authTokenNode.isMissingNode()) {
                token = authTokenNode.asText(); // Return the auth_token value
                if (token == null || token.isEmpty()) {                   
                    throw new RuntimeException("Authentication failed: Token is null or empty.");
                }
                return token;
            }else {
            	// If auth_token is not found, return null
            	throw new RuntimeException("Auth token not found in the response.");
            }            
        } catch (Exception e) {
            logger.error("Error parsing auth token: {}", e.getMessage(), e);
            return null;
        }
    }
}
