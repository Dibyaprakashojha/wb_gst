package com.uneecops.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class AppConfigure {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

