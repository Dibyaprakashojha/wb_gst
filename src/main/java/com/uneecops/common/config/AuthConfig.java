package com.uneecops.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "gst.auth")
@Getter
@Setter
public class AuthConfig {

	private String client_id;
	private String client_secret;
	private String user_id;
	private String request_url;

}
