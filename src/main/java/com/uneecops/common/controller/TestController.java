package com.uneecops.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uneecops.common.ServiceImplementation.RefundServ;
import com.uneecops.common.repository.TimeStampRepo;
import com.uneecops.common.service.MakeApiRequest;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private MakeApiRequest makeApiRequest;

	@Autowired
	private TimeStampRepo timeStampRepo;

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

//    2024-09-30:00:00 
	@GetMapping("/check")
	public String checkCrn() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
		String endDate = "2024-09-30:00:00 ";
		for (int i = 0; i < 240; i++) {

			String res = makeApiRequest.makeCommonApiRequest("291d9190faa14a28b6f840f348ec1b3f", "N", endDate);
			if (res != null && res.contains("AA190924046837K")) {
				return "FOUND";
			}
			endDate = sdf.format(new Date(sdf.parse(endDate).getTime() + TimeUnit.HOURS.toMillis(1)));
			System.out.println(endDate);
		}
		return "Not Found";

	}

	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		timeStampRepo.deleteById(id);
	}
}
