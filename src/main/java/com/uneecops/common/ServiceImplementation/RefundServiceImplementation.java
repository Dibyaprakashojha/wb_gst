package com.uneecops.common.ServiceImplementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.entity.CrnList;
import com.uneecops.common.entity.DayCount;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.TimeCount;
import com.uneecops.common.repository.CrnListRepo;
import com.uneecops.common.repository.DayCountRepo;
import com.uneecops.common.repository.RfndResponseRepo;
import com.uneecops.common.repository.TimeStampRepo;
import com.uneecops.common.service.AuthenticationService;
import com.uneecops.common.service.CommonService;
import com.uneecops.common.service.RefundService;
import com.uneecops.common.service.TimeStampService;
import com.uneecops.common.validation.CommonValidation;

import jakarta.transaction.Transactional;

@Service
public class RefundServiceImplementation implements RefundService {

	private static final Logger logger = LoggerFactory.getLogger(RefundServiceImplementation.class);

	@Autowired
	private TimeStampRepo timeStampRepository;

	@Autowired
	private AuthenticationService authenticationApiService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private TimeStampService timeStampService;

	@Autowired
	private DayCountRepo dayCountRepo;

	@Autowired
	private CrnListRepo crnListRepo;
	
	@Autowired
	private RfndResponseRepo responseRepo;

	private List<DayCount> dayCountData;

	private List<CrnList> crnData;

	private boolean flag = false;

	@Override
	public void fetchRefundRecords() {
		List<RfdResponse> refundResponses = new ArrayList<>();
		logger.info("Starting fetchRefundRecords process");
		try {
			// Fetch End Time From Db
			String endTime = timeStampRepository.findMaxEndTime();

			// Extract Date from End Time
			LocalDate extractedDate = LocalDate.parse(endTime.split(":")[0]);

			// Check That EndTime Is Less Than Current Time
			if (!CommonValidation.fetchTimeValidation(endTime)) {
				logger.warn("Invalid or null endTime. Skipping refund process.");
				return;
			}

			// Call Authentication
			String authToken = authenticationApiService.authenticate();
			logger.info("Authentication successful. Fetching DayCount data...");
//			
			// Check if Data Already Exists
			Integer dataExists = dayCountRepo.existsByEndTimeDate(extractedDate);

			// Convert Integer result to Boolean
			boolean isDataPresent = dataExists != null && dataExists == 1;

			// Fetch DayCount Data
			if (!isDataPresent || extractedDate.equals(LocalDate.now())) {
				dayCountData = commonService.invokeDayCount_Api(authToken, endTime, "Y");
			} else {
				logger.info("DayCount Data Already Exist For the Date:" + extractedDate);
				flag = true;
				dayCountData = dayCountRepo.findByEndTimeDate(extractedDate);
			}

			// Fetch CRN Data Only If DayCount Data Exists
			if (!ObjectUtils.isEmpty(dayCountData)) {
				logger.info("Fetching CRN data...");
				try {
					crnData = commonService.invokeCRNlIST_Api(authToken, endTime);

					if (!ObjectUtils.isEmpty(crnData)) {
						logger.info("CRN data fetched successfully: {} records", crnData.size());

						for (CrnList crnObj : crnData) {
							logger.debug("Processing CRN: {}", crnObj.getCrn());
							String crnNumb = crnObj.getCrn();
							try {
								RfdResponse refundResponse = commonService.invoke_RefundApi(authToken, crnNumb);
								if (refundResponse != null) {
									refundResponses.add(refundResponse);
								}
							} catch (Exception e) {
								logger.error("Error on Adding refund Response To RefundResponses List: {}", crnNumb, e);
							}
						}
					} else {
						// save StartTime EndTime if Crn Data Is Not Available
						timeStampService.saveTimestamp(endTime);
						logger.info("Time Intervals Are Save In which time Stamp CrnData In Not Available");
						return;
					}
					// Save all records
					saveAll(crnData, dayCountData, endTime, refundResponses);
			} catch (Exception e) {
					logger.error("Error fetching CRN data", e.getMessage(), e);
					throw new RuntimeException(e.getMessage());
				}
			} else {
	//			 save StartTime EndTime If No DayCount Data Is Available
				timeStampService.saveTimestamp(endTime);
			}

		} catch (Exception e) {
//			 Log the exception with its stack trace
			logger.error("An error occurred while fetching refund records: {}", e.getMessage() , e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@Transactional
	public void saveAll(List<CrnList> crnData, List<DayCount> dayCountData, String endTime,
			List<RfdResponse> refundResponses) {

		try {
			TimeCount timeCount = timeStampService.saveTimestamp(endTime);
			
//			if(timeCount != null) {
//				throw new RuntimeException("Testing==============================================");
//			}

//			timeStampRepo.save(timeCount);
			
	
			// Associate TimeCount with DayCount
			for (DayCount dayCount : dayCountData) {
				dayCount.setTimeCount(timeCount);
			}

			// Associate TimeCount with CrnList
			for (CrnList crnList : crnData) {
				crnList.setTimeCount(timeCount);
			}
			// Check That If dayCountData Hold Existing Record Then Update Only EndTime
			if (flag) {
				// Update only endTime for existing DayCount records
				for (DayCount dayCount : dayCountData) {
					dayCount.setEndTime(
							LocalDateTime.parse(endTime.replaceFirst(":", "T"), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
				}
				dayCountRepo.saveAll(dayCountData);
				logger.info("Updated endTime for {} existing DayCount records.", dayCountData.size());
			} else {
//				timeCount.getDayCounts().addAll(dayCountData);
				// Directly save new records In DayCount Entity Class
				List<DayCount> savedDayCountRecords = dayCountRepo.saveAll(dayCountData);
				logger.info("Successfully saved {} new DayCount records.", savedDayCountRecords.size());
			}

			// save CrnList Records
//			timeCount.getDayCounts().addAll(dayCountData);
			List<CrnList> crnListsRecords = crnListRepo.saveAll(crnData);
			logger.info("Successfully saved {} crnListsRecords records to the database.", crnListsRecords.size());

			// save case data details of refund API
			List<RfdResponse> savedCaseDataDet = responseRepo.saveAll(refundResponses);
			logger.info("Successfully saved {} rfdResponses records to the database.", savedCaseDataDet.size());
			

		} catch (Exception e) {
			throw new RuntimeException("Error Getting In During Saving The All Data"+" "+e.getMessage());
		}

	}
}
