package com.uneecops.common.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.CommonDocDetails_Dto;
import com.uneecops.common.dto.CommonTaxOfficerDet_Dto;
import com.uneecops.common.dto.DeclarationDocDto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.RejRefAmountCessDDto;
import com.uneecops.common.dto.RejRefAmountCgstDto;
import com.uneecops.common.dto.RejRefAmountIgstDto;
import com.uneecops.common.dto.RejRefAmountSgstDto;
import com.uneecops.common.dto.RfdPMT_03_Dto;
import com.uneecops.common.dto.ScrnSpecDetRejectedAmntData_Dto;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.RfdRejAmntDocDetails;
import com.uneecops.common.entity.RfdRejAmntToDet;
import com.uneecops.common.entity.RfdRejDeclnDoc;
import com.uneecops.common.entity.RfdRejectedAmntData;
import com.uneecops.common.entity.RfdResponse;

public class RfdPMT03Mapper {

	public static Items mapToEntity(RfdPMT_03_Dto dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto)) {
			return null;
		}
		Items item = new Items();
		BeanUtils.copyProperties(dto, item);
		RfdRejectedAmntData rfdRejectedAmntData = setCommonValues(new RfdRejectedAmntData() , rfdResponse);
		ScrnSpecDetRejectedAmntData_Dto rejectedAmntData_Dto = dto.getRfdRejectedAmntData().getScrnSpecDetCompAdmntOrdData();
		if(rejectedAmntData_Dto != null) {
			BeanUtils.copyProperties(dto, rfdRejectedAmntData);
			rfdRejectedAmntData.setRejAmtorderType(rejectedAmntData_Dto.getRfd_RejctedAmnt().getOrderType());
			rfdRejectedAmntData.setRfdProSanOrderNo(rejectedAmntData_Dto.getRfd_RejctedAmnt().getRfdProSanOrderNo());
			rfdRejectedAmntData.setRemarks(rejectedAmntData_Dto.getRfd_RejctedAmnt().getRemarks());
			if(rejectedAmntData_Dto.getRfd_RejctedAmnt().getRefRejectedAmntDetails() != null) {
			mapRejRefAmntCess(rejectedAmntData_Dto.getRfd_RejctedAmnt()
					.getRefRejectedAmntDetails().getRejRefAmntCess(), rfdRejectedAmntData);
			mapRejRefAmntCgst(rejectedAmntData_Dto.getRfd_RejctedAmnt()
					.getRefRejectedAmntDetails().getRejRefAmntCgst(), rfdRejectedAmntData);
			mapRejRefAmntIgst(rejectedAmntData_Dto.getRfd_RejctedAmnt()
					.getRefRejectedAmntDetails().getRejRefAmntIgst(), rfdRejectedAmntData);
			mapRejRefAmntSgst(rejectedAmntData_Dto.getRfd_RejctedAmnt()
					.getRefRejectedAmntDetails().getRejRefAmntSgst(), rfdRejectedAmntData);
			}
			rfdRejectedAmntData.setDeclarationDocs(mapDeclarationDocs(
					rejectedAmntData_Dto.getRfd_RejctedAmnt().getDeclarationDoc(), rfdRejectedAmntData , rfdResponse));
			rfdRejectedAmntData.setRfdRejAmntDocDetails(mapRejAmntDocDetails(dto.getRfdRejectedAmntData().getCommonDocDetails() , rfdRejectedAmntData , rfdResponse));
			rfdRejectedAmntData.setRfdRejAmntToDet(mapRejAmntToDet(dto.getRfdRejectedAmntData().getCommonTaxOfficerDet() , rfdRejectedAmntData , rfdResponse));		
		}
		item.setRfdRejectedAmntData(rfdRejectedAmntData);
		rfdRejectedAmntData.setItem(item);
		item.setCrn(rfdResponse.getCrn());
		item.setGstin(rfdResponse.getGstin());
		item.setRfdResponse(rfdResponse);
		return item;
	}

	public static List<Items> mapToEntityList(ItemDto itemDto , RfdResponse rfdResponse) {
		// if (ObjectUtils.isEmpty(dtoList)) return Collections.emptyList();
		/*
		 * List<RfdPMT03Entity> entityList = new ArrayList<>(); for (RfdPMT03DTO dto
		 * :dtoList) { entityList.add(RfdPMT03Mapper.mapToEntity(dto)); } return
		 * entityList;
		 */
		return itemDto.getRfdPMT03().stream().map(dto -> RfdPMT03Mapper.mapToEntity(dto, rfdResponse))
				.collect(Collectors.toList());
	}

	private static List<RfdRejAmntDocDetails> mapRejAmntDocDetails(List<CommonDocDetails_Dto> dtoList , RfdRejectedAmntData entity , RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dtoList))
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			RfdRejAmntDocDetails docDet = setCommonValues(new RfdRejAmntDocDetails() ,rfdResponse) ;
			BeanUtils.copyProperties(dto, docDet);
			docDet.setRfdRejectedAmntData(entity);
			return docDet;
		}).collect(Collectors.toList());
	}

	private static RfdRejAmntToDet mapRejAmntToDet(CommonTaxOfficerDet_Dto dto , RfdRejectedAmntData entity , RfdResponse rfdResponse) {
		if (dto == null)
			return null;
		RfdRejAmntToDet toDet = setCommonValues(new RfdRejAmntToDet() , rfdResponse);
		BeanUtils.copyProperties(dto, toDet);
		toDet.setRfdRejectedAmntData(entity);
		return toDet;
	}

	private static void mapRejRefAmntCess(RejRefAmountCessDDto dto, RfdRejectedAmntData entity) {
		entity.setCessFee(dto.getFee());
		entity.setCessIntrest(dto.getIntrest());
		entity.setCessOthers(dto.getOthers());
		entity.setCessPenalty(dto.getPenalty());
		entity.setCessTax(dto.getTax());
		entity.setCessTot(dto.getTot());
	}

	private static void mapRejRefAmntCgst(RejRefAmountCgstDto dto, RfdRejectedAmntData entity) {		
		entity.setCgstFee(dto.getFee());
		entity.setCgstIntrest(dto.getIntrest());
		entity.setCgstOthers(dto.getOthers());
		entity.setCgstPenalty(dto.getPenalty());
		entity.setCgstTax(dto.getTax());
		entity.setCgstTot(dto.getTot());
	}

	private static void mapRejRefAmntIgst(RejRefAmountIgstDto dto, RfdRejectedAmntData entity) {

		entity.setIgstFee(dto.getFee());
		entity.setIgstIntrest(dto.getIntrest());
		entity.setIgstOthers(dto.getOthers());
		entity.setIgstPenalty(dto.getPenalty());
		entity.setIgstTax(dto.getTax());
		entity.setIgstTot(dto.getTot());

	}

	private static void mapRejRefAmntSgst(RejRefAmountSgstDto dto, RfdRejectedAmntData entity) {
		entity.setSgstFee(dto.getFee());
		entity.setSgstIntrest(dto.getIntrest());
		entity.setSgstOthers(dto.getOthers());
		entity.setSgstPenalty(dto.getPenalty());
		entity.setSgstTax(dto.getTax());
		entity.setSgstTot(dto.getTot());
	}

	private static List<RfdRejDeclnDoc> mapDeclarationDocs(List<DeclarationDocDto> dtoList,
			RfdRejectedAmntData rejAmntData , RfdResponse rfdResponse) {
		if (dtoList == null || dtoList.isEmpty())
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			RfdRejDeclnDoc entity = setCommonValues(new RfdRejDeclnDoc() , rfdResponse);
			BeanUtils.copyProperties(dto, entity);
			entity.setRfdRejectedAmntData(rejAmntData);
			return entity;
		}).collect(Collectors.toList());
	}
	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
	    entity.setGstin(rfdResponse.getGstin());
	    entity.setCrn(rfdResponse.getCrn());
	    return entity;
	}
}
