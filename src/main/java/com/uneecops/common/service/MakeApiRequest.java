package com.uneecops.common.service;

//import java.util.List;

public interface MakeApiRequest {

	String makeCommonApiRequest(String authToken, String iseod, String endTime);

	String makeRefundApiRequest(String authToken, String crn);

}
