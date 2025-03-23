package com.uneecops.common.ServiceImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uneecops.common.service.MakeApiRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MakeApiRequestImplementation implements MakeApiRequest {

	private static final Logger logger = LoggerFactory.getLogger(MakeApiRequestImplementation.class);

	@Value("${thirdparty.api.auth.url}")
	private String authUrl;

	@Value("${thirdparty.api.common.url}")
	private String commonUrl;

	@Value("${thirdparty.api.refund.url}")
	private String refundUrl;

	@Value("${thirdparty.api.casetyp}")
	private String casetyp;

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
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String makeCommonApiRequest(String authToken, String iseod, String endTm) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
		String responsebody = null;

		String startTm = endTm;
		String endTime = null;
		try {
			Date endDate = sdf.parse(endTm);
			endDate = new Date(endDate.getTime() + TimeUnit.HOURS.toMillis(1));
			endTime = sdf.format(endDate);
		} catch (ParseException e) {
			logger.error("Error parsing the end time: {}", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}

		String url = commonUrl + "?action=CRNLST" + "&state_cd=" + stateCd + "&start_tm=" + startTm + "&end_tm="
				+ endTime + "&casetyp=" + casetyp + "&iseod=" + iseod;

		HttpHeaders headers = new HttpHeaders();
		headers.set("clientid", clientId);
		headers.set("client-secret", clientSecret);
		headers.set("username", username);
		headers.set("state-cd", stateCd);
		headers.set("auth-token", authToken);
		headers.set("Accept", "application/json");
		headers.set("Media-Type", "application/json");
		headers.set("Content-Type", "application/json");

		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					String.class);

			if (response.getBody() != null) {
				responsebody = response.getBody();
				if (responsebody.contains("\"status_cd\":\"0\"") && responsebody.contains("\"error\"")) {
					logger.warn("Error response received: {}", responsebody);
					throw new RuntimeException(responsebody);
				}
				logger.info("Response Body for iseod {}: {}", iseod, responsebody);
				String responses = decodeData(responsebody);
				return responses;
			} else {
				logger.error("Error fetching data: {}", response.getBody());
				return null;
			}
		} catch (Exception e) {
			logger.error("Error during Common API call: {}", e.getMessage());
		}
		return null;
	}

	@Override
	public String makeRefundApiRequest(String authToken, String crn) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("clientid", clientId);
		headers.set("client-secret", clientSecret);
		headers.set("username", username);
		headers.set("state-cd", stateCd);
		headers.set("auth-token", authToken);
		headers.set("Accept", "application/json");
		headers.set("Media-Type", "application/json");
		headers.set("Content-Type", "application/json");

		String url = refundUrl + "?action=GETCASEDATA" + "&state_cd=" + stateCd + "&crn=" + crn;

		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					String.class);

			if (response.getStatusCode() == HttpStatus.OK) {
				String responses = decodeData(response.getBody());
				logger.info("Refund data successfully retrieved for CRN: {}", crn);
				return responses;
			} else {
				logger.error("Error fetching refund data: {}", response.getBody());
				return null;
			}
		} catch (Exception e) {
			logger.error("Error during refund API call: {}", e.getMessage());
			return null;
		}
	}

	private String decodeData(String responseBody) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(responseBody);

			JsonNode dataNode = rootNode.path("data");
			if (dataNode.isMissingNode() || dataNode.asText().isEmpty()) {
				logger.warn("Data field is missing or empty in the response.");
			}

			String base64Data = dataNode.asText();
			logger.info("Base64 Encoded Data: {}", base64Data);

			byte[] decodedData = java.util.Base64.getDecoder().decode(base64Data);
			String decodedString = new String(decodedData);
			logger.info("Decoded Data: {}", decodedString);

			if (ObjectUtils.isEmpty(decodedString)) {
				throw new RuntimeException("Api Response Is Empty");
			}
			return decodedString;
		} catch (Exception e) {
			logger.error("Error parsing refund case data: {}", e.getMessage());
			return "Error decoding response";
		}
	}
}
