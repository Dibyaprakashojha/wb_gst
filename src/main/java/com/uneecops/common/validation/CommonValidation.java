package com.uneecops.common.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonValidation {

	private static final Logger logger = LoggerFactory.getLogger(CommonValidation.class);

	public static boolean fetchTimeValidation(String endTime) {
		logger.info("Strat fetchTimeValidation for endTime: {}", endTime);
		if (ObjectUtils.isEmpty(endTime)) {
			throw new RuntimeException("Invalid or null endTime. EndTime Must Be available In Database");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
		try {
			// Parse the endTime string to a Date object
			Date endDate = sdf.parse(endTime);
			Date currentDate = new Date(); // Current system date and time
			endDate = new Date(endDate.getTime() + TimeUnit.HOURS.toMillis(1));
			// Validate the endTime
			if (!endDate.before(currentDate)) {
				// logger.warn("End time {} is not before current time {}. Validation failed!",
				// sdf.format(endDate), sdf.format(currentDate));
				throw new IllegalArgumentException("Invalid endTime: End time must be before the current time.");
			}

		} catch (Exception e) {
			logger.error("Error parsing endTime: {}. Exception: {}", endTime, e.getMessage(), e);
			return false; // Return false if there was an error
		}

		logger.info("fetchTimeValidation successful for endTime: {}", endTime);
		return true; // endTime is valid
	}
	
	
	
	
	
//	@Override
//	public RfdResponse invoke_RefundApi(String authToken, String crn) {
//	    logger.info("Received authToken And Crn For Invoke Refund Api.");
//	    String response = makeApiRequest.makeRefundApiRequest(authToken, crn);
//	    
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        RfdResponseDto rfdResponseDto = objectMapper.readValue(response, RfdResponseDto.class);
//
//	        RfdResponse rfdResponse = new RfdResponse();
//	        BeanUtils.copyProperties(rfdResponseDto, rfdResponse);
//	        List<Items> itemList = new ArrayList<>();
//
//	        if (rfdResponseDto.getItems() != null) {
//	            for (ItemDto dto : rfdResponseDto.getItems()) {
//	                
//	                if (dto.getRefId() != null || dto.getRefDt() != null || dto.getHash() != null || dto.getItemName() != null) {
//	                    
//	                    // Create a new Item for each DTO entry
//	                    Items item = new Items();
//	                    item.setRefId(dto.getRefId());
//	                    item.setHash(dto.getHash());
//	                    item.setRefDt(dto.getRefDt());
//	                    item.setItemName(dto.getItemName());
//
//	                    // Establish parent-child relationship
//	                    item.setRfdResponse(rfdResponse);
//	                    
//	                    // Map RfndApplicationData only if available
//	                    if (!ObjectUtils.isEmpty(dto.getRfdAppData())) {
//	                        item.setRfdAppData(RfndApplicationDataMapper.mapRfndApplicationData(dto.getRfdAppData()));
//	                    }
//
//	                    // Map RfdNotice only if available
//	                    if (!ObjectUtils.isEmpty(dto.getRfdNotice())) {                        
//	                        List<RfdNotice> rfdNoticeList = RfdNoticeMapper.mapRfdNoticeList(dto.getRfdNotice(), item);
//
//	                        if (!rfdNoticeList.isEmpty()) {
//	                            for (RfdNotice rfdNotice : rfdNoticeList) {
//	                                // Create a new Item for each notice if needed
//	                                Items noticeItem = new Items();
//	                                noticeItem.setRefId(dto.getRefId());
//	                                noticeItem.setHash(dto.getHash());
//	                                noticeItem.setRefDt(dto.getRefDt());
//	                                noticeItem.setItemName(dto.getItemName());
//	                                noticeItem.setRfdResponse(rfdResponse);
//
//	                                // Associate Notice with Item
//	                                noticeItem.setRfdNotice(rfdNotice);
//
//	                                // Add noticeItem to itemList
//	                                itemList.add(noticeItem);
//	                            }
//	                        }
//	                    }
//
//	                    // Map RfdPMT03 only If Available
//	                    if (!ObjectUtils.isEmpty(dto.getRfdPMT03())) {
//	                        rfdResponse.setRfdPMT03(RfdPMT03Mapper.mapToEntityList(dto.getRfdPMT03(), rfdResponse));
//	                    }
//
//	                    // Map RfdReply only if available
//	                    if (!ObjectUtils.isEmpty(dto.getRfdReply())) {
//	                        rfdResponse.setRfdReply(RfdReplyMapper.mapToEntityList(dto.getRfdReply(), rfdResponse));
//	                    }
//
//	                    // Map RfdPaymAdv Only If Available
//	                    if (!ObjectUtils.isEmpty(dto.getRfdPaymentAdv())) {
//	                        rfdResponse.setRfdPaymentAdv(RfdPaymAdvMapper.mapToEntityList(dto.getRfdPaymentAdv(), rfdResponse));
//	                    }
//
//	                    // Map RfdSanCtionOrderData Only If Available (inside item loop ✅)
//	                    if (!ObjectUtils.isEmpty(dto.getRfdSanOrderData())) {
//	                        item.setRfdSanOrderData(RfdSanctionOrderDataMapper.mapToEntity(dto.getRfdSanOrderData()));
//	                    }
//
//	                    // Add item to the itemList
//	                    itemList.add(item);
//	                }
//	            }
//	            rfdResponse.setItems(itemList);
//	        }
//
//	        return rfdResponse;
//
//	    } catch (Exception e) {
//	        logger.error("Error parsing JSON or saving data: {}", e.getMessage(), e);
//	        throw new RuntimeException("Error parsing JSON or saving data: " + e.getMessage(), e);
//	    }
//	}

}
