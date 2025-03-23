//package com.uneecops.common.ServiceImplementation;
//
////import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ObjectUtils;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.uneecops.common.dto.CrnListDTO;
//import com.uneecops.common.dto.CrnResponseDTO;
//import com.uneecops.common.dto.DayCountDTO;
//import com.uneecops.common.dto.ItemDto;
//import com.uneecops.common.dto.RfdResponseDto;
//import com.uneecops.common.entity.CrnList;
//import com.uneecops.common.entity.DayCount;
//import com.uneecops.common.entity.Items;
//import com.uneecops.common.entity.RfdNotice;
//import com.uneecops.common.entity.RfdResponse;
//import com.uneecops.common.entity.TimeCount;
//import com.uneecops.common.mapper.RfdNoticeMapper;
//import com.uneecops.common.mapper.RfdPMT03Mapper;
//import com.uneecops.common.mapper.RfdPaymAdvMapper;
//import com.uneecops.common.mapper.RfdReplyMapper;
//import com.uneecops.common.mapper.RfdSanctionOrderDataMapper;
//import com.uneecops.common.mapper.RfndApplicationDataMapper;
//import com.uneecops.common.repository.DayCountRepo;
//import com.uneecops.common.service.CommonService;
//import com.uneecops.common.service.MakeApiRequest;
//import com.uneecops.common.service.TimeStampService;
//
//@Service
//public class CommonServiceImpl implements CommonService {
//
//	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
//
//	@Autowired
//	private MakeApiRequest makeApiRequest;
//
//	@Autowired
//	private DayCountRepo dayCountRepo;
//
//	@Autowired
//	private TimeStampService timeStampService;
//
//	protected boolean flag = false;
//
//	LocalDateTime currentDateTime = LocalDateTime.now();
//
//	@Override
//	public List<CrnList> invokeCRNlIST_Api(String authToken, String endTm) {
//		String iseod = "N";
//		logger.info("Fetching CRN list for authToken: {} and endTm: {}", authToken, endTm);
//
//		try {
//			TimeCount timeCount = new TimeCount();
//			String response = makeApiRequest.makeCommonApiRequest(authToken, iseod, endTm);
//			if (response != null) {
//				// Convert JSON String to CrnResponseDTO
//				ObjectMapper objectMapper = new ObjectMapper();
//				CrnResponseDTO crnResponse = objectMapper.readValue(response, CrnResponseDTO.class);
//
//				// Extract crnlist from response
//				List<CrnListDTO> crnListDtos = crnResponse.getCrnlist();
//				logger.info("Successfully parsed JSON into CrnResponseDTO.");
//
//				if (crnListDtos == null || crnListDtos.isEmpty()) {
//					logger.warn("No Crn data found in API response.");
//					return Collections.emptyList();
//				}
//
//				// Convert DTO list to Entity list
//				List<CrnList> crnlists = new ArrayList<>();
//				for (CrnListDTO crnListDTO : crnListDtos) {
//					CrnList crnList = new CrnList();
//					crnList.setCrn(crnListDTO.getCrn());
//					crnList.setUpdateTmstmp(crnListDTO.getUpdateTmstmp());
//					crnList.setApprovAuth(crnListDTO.getApprovAuth());
//					crnList.setCasetyp(crnListDTO.getCasetyp());
//					crnList.setStatus(crnListDTO.getStatus());
//					crnList.setTimeCount(timeCount); // Set FK reference
//					crnlists.add(crnList);
//
//				}
//
//				return crnlists;
//			} else {
//				return null;
//			}
//
//		} catch (Exception e) {
////			logger.error("Error processing Crn data: {}", e.getMessage());
//			throw new RuntimeException("Error processing Crn data: " + e.getMessage());
//		}
//	}
//
//	@Override
//	public List<DayCount> invokeDayCount_Api(String authToken, String endTm, String iseod) {
//		try {
//			TimeCount timeCount = new TimeCount();
//			String response = makeApiRequest.makeCommonApiRequest(authToken, iseod, endTm);
//
//			// Convert JSON response to a map
//			ObjectMapper objectMapper = new ObjectMapper();
//			Map<String, List<DayCountDTO>> responseMap = objectMapper.readValue(response,
//					new TypeReference<Map<String, List<DayCountDTO>>>() {
//					});
//
//			List<DayCountDTO> daycountDtos = responseMap.getOrDefault("daycnt", Collections.emptyList());
//
//			if (daycountDtos.isEmpty()) {
//				logger.warn("No DayCount data found in API response.");
//				return handleEmptyDayCountData(endTm);
//			}
//
//			logger.info("Processing {} DayCount records.", daycountDtos.size());
//
//			// Convert DTO list to Entity list
//			// Convert DTO list to Entity list and set TimeCount foreign key
//			List<DayCount> dayCounts = daycountDtos.stream().map(dto -> {
//				DayCount dayCount = new DayCount();
//				dayCount.setCasetyp(dto.getCasetyp());
//				dayCount.setCnt(dto.getCnt());
//				dayCount.setEndTime(LocalDateTime.parse(endTm, DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm")));
//				dayCount.setCreatedAt(LocalDateTime.now());
//				dayCount.setTimeCount(timeCount); // Set FK reference
//				return dayCount;
//			}).collect(Collectors.toList());
//
//			return dayCounts;
//		} catch (Exception e) {
//			logger.error("Error processing DayCount data: {}", e.getMessage());
//			throw new RuntimeException("DayCount data processing error: " + e.getMessage());
//		}
//	}
//
//	private List<DayCount> handleEmptyDayCountData(String endTm) {
//
//		TimeCount timeCount = new TimeCount();
//		// If In that Date There Is No Data create a default entry
//		logger.warn("Received empty DayCount data for  endTm:" + endTm);
//		DayCount defaultDayCount = new DayCount();
//		defaultDayCount.setCasetyp(null);
//		defaultDayCount.setCnt(0);
//		defaultDayCount.setEndTime(LocalDateTime.parse(endTm, DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm")));
//		defaultDayCount.setCreatedAt(LocalDateTime.now());
//		defaultDayCount.setTimeCount(timeCount);
//		// Save default data
//		dayCountRepo.save(defaultDayCount);
//		timeStampService.saveTimestamp(endTm);
//
//		return Collections.singletonList(defaultDayCount);
//
//	}
//
//	@Override
//	public RfdResponse invoke_RefundApi(String authToken, String crn) {
//		logger.info("Received authToken And Crn For Invoke Refund Api.");
//		String response = makeApiRequest.makeRefundApiRequest(authToken, crn);
//		try {
//
//			ObjectMapper objectMapper = new ObjectMapper();
//			RfdResponseDto rfdResponseDto = objectMapper.readValue(response, RfdResponseDto.class);
//
//			RfdResponse rfdResponse = new RfdResponse();
//			BeanUtils.copyProperties(rfdResponseDto, rfdResponse);
//			List<Items> itemList = new ArrayList<>();
//			if (rfdResponseDto.getItems() != null && !CollectionUtils.isEmpty(itemList)) {
//				for (ItemDto dto : rfdResponseDto.getItems()) {
//					Items item = new Items();
//					if (dto.getRefId() != null || dto.getRefDt() != null || dto.getHash() != null
//							|| dto.getItemName() != null) {
//
////						item.setRefId(dto.getRefId());
////
////						item.setHash(dto.getHash());
////
////						item.setRefDt(dto.getRefDt());
////
////						item.setItemName(dto.getItemName());
//						
//						BeanUtils.copyProperties(dto, item);
//						// Establish parent-child relationship
//						item.setRfdResponse(rfdResponse);
//						itemList.add(item);
//
//						// Map RfndApplicationData only if available
//						if (!ObjectUtils.isEmpty(dto.getRfdAppData())) {
//							item.setRfdAppData(RfndApplicationDataMapper.mapRfndApplicationData(dto.getRfdAppData() , item));
//
//						}
//						// Map RfdNotice only if available
//						else if (!ObjectUtils.isEmpty(dto.getRfdNotice())) {
//							List<RfdNotice> noticeList = RfdNoticeMapper.mapRfdNoticeList(dto.getRfdNotice(), item);
//							item.setRfdNotices(noticeList);
////							for (RfdNotice rfdNotc : noticeList) {
////								item.setHash(rfdNotc.getHash());
////								item.setItemName(rfdNotc.getItemName());
////								item.setRefDt(rfdNotc.getRefdt());
////								item.setRefId(rfdNotc.getRefId());
////							}
//						}
//
//						// Map RfdPMT03 only If Available
//						else if (!ObjectUtils.isEmpty(dto.getRfdPMT03())) {
//							item.setRfdPMT03(RfdPMT03Mapper.mapToEntityList(dto.getRfdPMT03(), item));
//						}
//
//						// Map RfdReply only if available
//						else if (!ObjectUtils.isEmpty(dto.getRfdReply())) {
//							item.setRfdReply(RfdReplyMapper.mapToEntityList(dto.getRfdReply(), item));
//						}
//
//						// Map RfdPaymAdv Only If Available
//						else if (!ObjectUtils.isEmpty(dto.getRfdPaymentAdv())) {
//							item.setRfdPaymentAdv(RfdPaymAdvMapper.mapToEntityList(dto.getRfdPaymentAdv(), item));
//						}
//
//						// Map RfdSanCtionOrderData Only If Available
//						else if (!ObjectUtils.isEmpty(dto.getRfdSanOrderData())) {
//							item.setRfdSanOrderData(RfdSanctionOrderDataMapper.mapToEntity(dto.getRfdSanOrderData(),item));
//						}
//					}
//
//				}
//				rfdResponse.setItems(itemList);
////logger.info("rfdResponse saved successfully: {}", rfdResponse);
//			}
//			// responseRepo.save(rfdResponse);
//			return rfdResponse;
//
//		} catch (Exception e) {
//			logger.error("Error parsing JSON or saving data: {}", e.getMessage(), e);
//			throw new RuntimeException("Error parsing JSON or saving data: " + e.getMessage(), e);
//		}
//	}
//
//}
