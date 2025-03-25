package com.uneecops.common.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.CommonDocDetails_Dto;
import com.uneecops.common.dto.CommonPayAdvRefAmntAllDto;
import com.uneecops.common.dto.CommonStatementRefundClaimDto;
import com.uneecops.common.dto.CommonTaxOfficerDet_Dto;
import com.uneecops.common.dto.CommonUnderTakingAmntDto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.PayAdvRejReasonDto;
import com.uneecops.common.dto.PayAdvScreenSpecCessDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecCgstDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecIgstDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecSgstDataDto;
import com.uneecops.common.dto.PaymAdvDetailsDto;
import com.uneecops.common.dto.RfdPaymentAdv_Dto;
import com.uneecops.common.dto.UndertakingAmtDetails_Dto;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.PayAdvDelayedRefIntCess;
import com.uneecops.common.entity.PayAdvDelayedRefIntCgst;
import com.uneecops.common.entity.PayAdvDelayedRefIntIgst;
import com.uneecops.common.entity.PayAdvDelayedRefIntSgst;
import com.uneecops.common.entity.PayAdvNetRefAmntSacCess;
import com.uneecops.common.entity.PayAdvNetRefAmntSacCgst;
import com.uneecops.common.entity.PayAdvNetRefAmntSacIgst;
import com.uneecops.common.entity.PayAdvNetRefAmntSacSgst;
import com.uneecops.common.entity.PayAdvRejReason;
import com.uneecops.common.entity.PaymAdvAmntDetails;
import com.uneecops.common.entity.RfdPayAdvDocDet;
import com.uneecops.common.entity.RfdPayAdvToDet;
import com.uneecops.common.entity.RfdPaymentAdvOrderData;
import com.uneecops.common.entity.RfdReplyData;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.UndertakingAmtDetails;
import com.uneecops.common.enums.PayAdvRefAmount;
import com.uneecops.common.enums.TaxType;
import com.uneecops.common.enums.UnderTakingAmount;

public class RfdPaymAdvMapper {

	public static Items maptoEnt(RfdPaymentAdv_Dto dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		
		Items item = setCommonValues(new Items() , rfdResponse);
		RfdPaymentAdvOrderData advOrderData = setCommonValues(new RfdPaymentAdvOrderData() , rfdResponse);
		BeanUtils.copyProperties(dto, item); 
		if(advOrderData!=null) {			
			advOrderData.setCommonDocDetails(advDocDetMapper(dto.getRfdPaymentAdvcOrderData(). getCommonDocDetails() ,  rfdResponse , advOrderData));
			advOrderData.setCommonTaxOfficerDet(advToDetMapper(dto.getRfdPaymentAdvcOrderData().getCommonTaxOfficerDet() , rfdResponse , advOrderData));
//			advOrderData.setScrnSpecDetCompAdmntOrdData(specDetPaymAdvOrdDataMapper(dto.getScrnSpecDetCompAdmntOrdData()));
			advOrderData.setCwfInitiatedIndicator(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getCwfInitiatedIndicator());
			advOrderData.setOrderType(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getOrderType());
			advOrderData.setRfdOrderType(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getRfdOrderType());
			advOrderData.setRfdProSanOrdNo(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getRfdProSanOrdNo());
			advOrderData.setPrevPaymAdvNo(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPrevPaymAdvNo());
			advOrderData.setRemarks(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getRemarks());
			advOrderData.setPayAdvStatus(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPayAdvStatus());
			advOrderData.setDisbursedAmnt(dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getDisbursedAmnt());
//			advOrderData.setPaymAdvDet(
//					paymAdvDetailsMapper(dto.getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet()));
//			advOrderData.setAdvDelayedRefIntCess(payAdvDelayedRefIntCessmapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCessData(),
//					advOrderData));
//			advOrderData.setAdvNetRefAmntSacCess(payAdvNetRefAmntSacCessMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCessData(),
//					advOrderData));
//			advOrderData.setAdvDelayedRefIntCgst(payAdvDelayedRefIntCgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCgstData(),
//					advOrderData));
//			advOrderData.setAdvNetRefAmntSacCgst(payAdvNetRefAmntSacCgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCgstData(),
//					advOrderData));
//
//			advOrderData.setAdvDelayedRefIntIgst(payAdvDelayedRefIntIgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecIgstData(),
//					advOrderData));
//
//			advOrderData.setAdvNetRefAmntSacIgst(payAdvNetRefAmntSacIgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecIgstData(),
//					advOrderData));
//
//			advOrderData.setAdvDelayedRefIntSgst(payAdvDelayedRefIntSgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecSgstData(),
//					advOrderData));
//
//			advOrderData.setAdvNetRefAmntSacSgst(payAdvNetRefAmntSacSgstMapper(
//					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecSgstData(),
//					advOrderData));
			advOrderData.setPaymAdvAmtDet(undertakingAmtDetailsMapper(advOrderData, dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet(), rfdResponse));

			advOrderData.setPayAdvRejReason(rejReasonMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPayAdvRejReason(), advOrderData));
		}		
		item.setRfdPaymentAdvcOrderData(advOrderData);
		advOrderData.setItem(item);
		item.setRfdResponse(rfdResponse);
		return item;
	}

	public static List<Items> mapToEntityList(ItemDto itemDto, RfdResponse rfdResponse) {

		return itemDto.getRfdPaymentAdv().stream().map(dto -> RfdPaymAdvMapper.maptoEnt(dto, rfdResponse))
				.collect(Collectors.toList());
	}
	
	private static List<PaymAdvAmntDetails> undertakingAmtDetailsMapper(RfdPaymentAdvOrderData advOrderData,
			PaymAdvDetailsDto details_Dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(details_Dto))
			return null;

		List<PaymAdvAmntDetails> PaymAdvAmntDetailList = new ArrayList<>();

		for (PayAdvRefAmount ammountType : PayAdvRefAmount.values()) {
			PaymAdvAmntDetails paymAdvAmntDetails = new PaymAdvAmntDetails();
			setCommonValues(paymAdvAmntDetails, rfdResponse);
			paymAdvAmntDetails.setRfdPaymentAdvOrderData(advOrderData);
			paymAdvAmntDetails.setAdvRefAmount(ammountType);

			combineTaxValues(details_Dto.getPayAdvScreenSpecIgstData(), paymAdvAmntDetails, TaxType.IGST, ammountType);
			combineTaxValues(details_Dto.getPayAdvScreenSpecCgstData(), paymAdvAmntDetails, TaxType.CGST, ammountType);
			combineTaxValues(details_Dto.getPayAdvScreenSpecSgstData(), paymAdvAmntDetails, TaxType.SGST, ammountType);
			combineTaxValues(details_Dto.getPayAdvScreenSpecCessData(), paymAdvAmntDetails, TaxType.CESS, ammountType);

			PaymAdvAmntDetailList.add(paymAdvAmntDetails);
		}

		return PaymAdvAmntDetailList;

	}
	private static void combineTaxValues(CommonPayAdvRefAmntAllDto amntDto, PaymAdvAmntDetails paymAdvAmntDetails,
			TaxType taxType, PayAdvRefAmount amountType) {
		if (amntDto == null)
			return;

		// Select the correct  amount type data
		CommonStatementRefundClaimDto undAmntData = switch (amountType) {
		case SANCTIONEDREFAMNT -> amntDto.getPayAdvNetRefAmntSac();
		case INTRESTDELAYREFAMNT -> amntDto.getPayAdvDelayedRefInt();
		};

		if (undAmntData != null) {
			setCombinedTaxValues(paymAdvAmntDetails, undAmntData, taxType);
		}
	}
	
	private static BigDecimal safeAdd(BigDecimal a, BigDecimal b) {
		return (a != null ? a : BigDecimal.ZERO).add(b != null ? b : BigDecimal.ZERO);
	}

	private static void setCombinedTaxValues(PaymAdvAmntDetails entity, CommonStatementRefundClaimDto dto,
			TaxType taxType) {
		if (dto == null)
			return;
		switch (taxType) {
		case IGST -> {
			entity.setIgstIntrest(safeAdd(entity.getIgstIntrest(), dto.getIntrest()));
			entity.setIgstOthers(safeAdd(entity.getIgstOthers(), dto.getOthers()));
			entity.setIgstFee(safeAdd(entity.getIgstFee(), dto.getFee()));
			entity.setIgstPenalty(safeAdd(entity.getIgstPenalty(), dto.getPenalty()));
			entity.setIgstTax(safeAdd(entity.getIgstTax(), dto.getTax()));
			entity.setIgstTot(safeAdd(entity.getIgstTot(), dto.getTot()));
		}
		case CGST -> {
			entity.setCgstIntrest(safeAdd(entity.getCgstIntrest(), dto.getIntrest()));
			entity.setCgstOthers(safeAdd(entity.getCgstOthers(), dto.getOthers()));
			entity.setCgstFee(safeAdd(entity.getCgstFee(), dto.getFee()));
			entity.setCgstPenalty(safeAdd(entity.getCgstPenalty(), dto.getPenalty()));
			entity.setCgstTax(safeAdd(entity.getCgstTax(), dto.getTax()));
			entity.setCgstTot(safeAdd(entity.getCgstTot(), dto.getTot()));
		}
		case SGST -> {
			entity.setSgstIntrest(safeAdd(entity.getSgstIntrest(), dto.getIntrest()));
			entity.setSgstOthers(safeAdd(entity.getSgstOthers(), dto.getOthers()));
			entity.setSgstFee(safeAdd(entity.getSgstFee(), dto.getFee()));
			entity.setSgstPenalty(safeAdd(entity.getSgstPenalty(), dto.getPenalty()));
			entity.setSgstTax(safeAdd(entity.getSgstTax(), dto.getTax()));
			entity.setSgstTot(safeAdd(entity.getSgstTot(), dto.getTot()));
		}
		case CESS -> {
			entity.setCessIntrest(safeAdd(entity.getCessIntrest(), dto.getIntrest()));
			entity.setCessOthers(safeAdd(entity.getCessOthers(), dto.getOthers()));
			entity.setCessFee(safeAdd(entity.getCessFee(), dto.getFee()));
			entity.setCessPenalty(safeAdd(entity.getCessPenalty(), dto.getPenalty()));
			entity.setCessTax(safeAdd(entity.getCessTax(), dto.getTax()));
			entity.setCessTot(safeAdd(entity.getCessTot(), dto.getTot()));
		}
		}
	}


	private static List<PayAdvRejReason> rejReasonMapper(List<PayAdvRejReasonDto> dtoList,
			RfdPaymentAdvOrderData advOrderData) {
		if (ObjectUtils.isEmpty(dtoList))
			return null;
		return dtoList.stream().map(dto -> {
			PayAdvRejReason advRejReason = new PayAdvRejReason();
			advRejReason.setRfdPaymentAdvOrderData(advOrderData);
			BeanUtils.copyProperties(dto, advRejReason);
			return advRejReason;
		}).collect(Collectors.toList());

	}

	private static List<RfdPayAdvDocDet> advDocDetMapper(List<CommonDocDetails_Dto> dtoList, RfdResponse rfdResponse ,  RfdPaymentAdvOrderData advOrderData) {
		if (ObjectUtils.isEmpty(dtoList))
			return null;
		return dtoList.stream().map(dto -> {
			RfdPayAdvDocDet advDocDet = setCommonValues(new RfdPayAdvDocDet() , rfdResponse) ;
			advDocDet.setRfdPaymentAdvOrderData(advOrderData);
			BeanUtils.copyProperties(dto, advDocDet);
			return advDocDet;
		}).collect(Collectors.toList());
	}

	private static RfdPayAdvToDet advToDetMapper(CommonTaxOfficerDet_Dto dto, RfdResponse rfdResponse , RfdPaymentAdvOrderData advOrderData) {
		if (ObjectUtils.isEmpty(dto) && dto == null)
			return null;
		RfdPayAdvToDet advToDet = setCommonValues(new RfdPayAdvToDet() , rfdResponse);
		BeanUtils.copyProperties(dto, advToDet);
		advToDet.setRfdPaymentAdvOrderData(advOrderData);
		return advToDet;
	}
	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
	    entity.setGstin(rfdResponse.getGstin());
	    entity.setCrn(rfdResponse.getCrn());
	    return entity;
	}
}
