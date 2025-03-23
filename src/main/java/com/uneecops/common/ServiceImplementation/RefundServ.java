package com.uneecops.common.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.RfdResponseDto;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.mapper.RfdNoticeMapper;
import com.uneecops.common.mapper.RfdPMT03Mapper;
import com.uneecops.common.mapper.RfdPaymAdvMapper;
import com.uneecops.common.mapper.RfdReplyMapper;
import com.uneecops.common.mapper.RfdSanctionOrderDataMapper;
import com.uneecops.common.mapper.RfndApplicationDataMapper;
import com.uneecops.common.repository.RfndResponseRepo;

@Service
public class RefundServ {
	@Autowired
	RfndResponseRepo rfndResponseRepo;

//    public  void saveRfndData(String jsonResponse){
//        try {
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            RfdResponseDto rfdResponseDto = objectMapper.readValue(jsonResponse, RfdResponseDto.class);
//
//            RfdResponse rfdResponse = new RfdResponse();
//            BeanUtils.copyProperties(rfdResponseDto, rfdResponse);
//            Optional.ofNullable(rfdResponseDto.getItems()).map(items -> items.stream()
////                    filter(dto -> {
////                return !ObjectUtils.isEmpty(dto.getItemName())// Remove empty items
////                        || !ObjectUtils.isEmpty(dto.getHash()) || !ObjectUtils.isEmpty(dto.getRefDt())
////                        || !ObjectUtils.isEmpty(dto.getRefId());
////            })
//                    .map(dto -> {
//                Items item = new Items();
//                BeanUtils.copyProperties(dto, item);
//                item.setRfdResponse(rfdResponse);
//
//                // Use method references for clean mapping
//                Optional.ofNullable(dto.getRfdAppData()).ifPresent(
//                        data -> item.setRfdAppData(RfndApplicationDataMapper.mapRfndApplicationData(data , item)));
//                Optional.ofNullable(dto.getRfdNotice())
//                        .ifPresent(data -> item.setRfdNotices(RfdNoticeMapper.mapRfdNoticeList(data, item)));
//                Optional.ofNullable(dto.getRfdPMT03())
//                        .ifPresent(data -> item.setRfdPMT03(RfdPMT03Mapper.mapToEntityList(data , item)));
//                Optional.ofNullable(dto.getRfdReply())
//                        .ifPresent(data -> item.setRfdReply(RfdReplyMapper.mapToEntityList(data , item)));
//                Optional.ofNullable(dto.getRfdPaymentAdv())
//                        .ifPresent(data -> item.setRfdPaymentAdv(RfdPaymAdvMapper.mapToEntityList(data , item)));
//                Optional.ofNullable(dto.getRfdSanOrderData()).ifPresent(
//                        data -> item.setRfdSanOrderData(RfdSanctionOrderDataMapper.mapToEntity(data , item)));
//
//                return item;
//            }).collect(Collectors.toList())).ifPresent(rfdResponse::setItems);
//
//            rfndResponseRepo.save(rfdResponse);
// //           logger.info("rfdResponse saved successfully: {}", rfdResponse);
//
//        } catch (Exception e) {
//  //          logger.error("Error parsing JSON or saving data: {}", e.getMessage(), e);
//            throw new RuntimeException("Error parsing JSON or saving data: " + e.getMessage(), e);
//        }
//    }
//	@SuppressWarnings("null")
	public void saveRfndData(String jsonResponse) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			RfdResponseDto rfdResponseDto = objectMapper.readValue(jsonResponse, RfdResponseDto.class);

			RfdResponse rfdResponse = new RfdResponse();
			BeanUtils.copyProperties(rfdResponseDto, rfdResponse);
			List<Items> itemList = new ArrayList<>();
			if (rfdResponseDto.getItems() != null) {

				for (ItemDto dto : rfdResponseDto.getItems()) {
					Items item =null;

					if (!ObjectUtils.isEmpty(dto)) {

//						BeanUtils.copyProperties(dto, item);

						// Map RfndApplicationData only if available
						if (!ObjectUtils.isEmpty(dto.getRfdAppData())) {							
							item=RfndApplicationDataMapper.mapRfndApplicationData(dto , rfdResponse);

						}
						// Map RfdNotice only if available
						else if (!CollectionUtils.isEmpty(dto.getRfdNotice())) {							
							List<Items> ntcItemsList = RfdNoticeMapper.mapRfdNoticeList(dto , rfdResponse);
							itemList.addAll(ntcItemsList);

						}

//						 Map RfdPMT03 only If Available
						else if (!CollectionUtils.isEmpty(dto.getRfdPMT03())) {
							List<Items> pmt03ItemList =RfdPMT03Mapper.mapToEntityList(dto , rfdResponse);
							itemList.addAll(pmt03ItemList);
						}
//
//						// Map RfdReply only if available
						else if (!CollectionUtils.isEmpty(dto.getRfdReply())) {
							List<Items> replyItemList = RfdReplyMapper.mapToEntityList(dto, rfdResponse);
							itemList.addAll(replyItemList);
						}
//
//						// Map RfdPaymAdv Only If Available
						else if (!CollectionUtils.isEmpty(dto.getRfdPaymentAdv())) {
							List<Items> payAdvItemList = RfdPaymAdvMapper.mapToEntityList(dto, rfdResponse);
							itemList.addAll(payAdvItemList);
						}

						// Map RfdSanCtionOrderData Only If Available
						else if (!ObjectUtils.isEmpty(dto.getRfdSanOrderData())) {
							item = RfdSanctionOrderDataMapper.mapToEntity(dto , rfdResponse);
						}
						// Establish parent-child relationship
	//					item.setRfdResponse(rfdResponse);
						itemList.add(item);
					}

				}
				rfdResponse.setItems(itemList);
//logger.info("rfdResponse saved successfully: {}", rfdResponse);
			}
			rfndResponseRepo.save(rfdResponse);
//			return rfdResponse;

		} catch (Exception e) {
//			logger.error("Error parsing JSON or saving data: {}", e.getMessage(), e);
			throw new RuntimeException("Error parsing JSON or saving data: " + e.getMessage(), e);
		}
	}
}
