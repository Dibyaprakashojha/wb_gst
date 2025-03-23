package com.uneecops.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uneecops.common.service.RefundService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CommonModTestApplication {
	
//	@Autowired
//	private RefundService refundService;

	public static void main(String[] args) {
		SpringApplication.run(CommonModTestApplication.class, args);
	}
	
//	@PostConstruct
//	public void init() {
//		refundService.fetchRefundRecords();
//	}

}
