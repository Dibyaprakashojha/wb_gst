package com.uneecops.common.service;

import java.util.List;

import com.uneecops.common.entity.CrnList;
import com.uneecops.common.entity.DayCount;
import com.uneecops.common.entity.RfdResponse;

public interface CommonService {

	List<CrnList> invokeCRNlIST_Api(String authToken, String endTm);

	List<DayCount> invokeDayCount_Api(String authToken, String endTm, String iseod);
	
	RfdResponse invoke_RefundApi(String authToken , String crn);

}
