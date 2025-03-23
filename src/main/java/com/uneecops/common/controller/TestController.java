package com.uneecops.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uneecops.common.ServiceImplementation.RefundServ;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/ping")
	public String ping() {
		return "Application is running!";
	}
	
	@Autowired
    private RefundServ rfdResponseService;

    @PostMapping("/save")
    public String saveTestData(@RequestBody String jsonResponse) {
        try {
            rfdResponseService.saveRfndData(jsonResponse);
            return "Data saved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing JSON: " + e.getMessage();
        }
    }
}
