package com.uneecops.common.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.CommonDocDetails_Dto;
import com.uneecops.common.dto.CommonTaxOfficerDet_Dto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.PayAdvRejReasonDto;
import com.uneecops.common.dto.PayAdvScreenSpecCessDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecCgstDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecIgstDataDto;
import com.uneecops.common.dto.PayAdvScreenSpecSgstDataDto;
import com.uneecops.common.dto.RfdPaymentAdvOrderData_Dto;
import com.uneecops.common.dto.RfdPaymentAdv_Dto;
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
import com.uneecops.common.entity.RfdPayAdvDocDet;
import com.uneecops.common.entity.RfdPayAdvToDet;
import com.uneecops.common.entity.RfdPaymentAdvOrderData;
import com.uneecops.common.entity.RfdResponse;

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
			advOrderData.setAdvDelayedRefIntCess(payAdvDelayedRefIntCessmapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCessData(),
					advOrderData));
			advOrderData.setAdvNetRefAmntSacCess(payAdvNetRefAmntSacCessMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCessData(),
					advOrderData));
			advOrderData.setAdvDelayedRefIntCgst(payAdvDelayedRefIntCgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCgstData(),
					advOrderData));
			advOrderData.setAdvNetRefAmntSacCgst(payAdvNetRefAmntSacCgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecCgstData(),
					advOrderData));

			advOrderData.setAdvDelayedRefIntIgst(payAdvDelayedRefIntIgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecIgstData(),
					advOrderData));

			advOrderData.setAdvNetRefAmntSacIgst(payAdvNetRefAmntSacIgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecIgstData(),
					advOrderData));

			advOrderData.setAdvDelayedRefIntSgst(payAdvDelayedRefIntSgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecSgstData(),
					advOrderData));

			advOrderData.setAdvNetRefAmntSacSgst(payAdvNetRefAmntSacSgstMapper(
					dto.getRfdPaymentAdvcOrderData().getScrnSpecDetCompAdmntOrdData().getPayAdviceOrder().getPaymAdvDet().getPayAdvScreenSpecSgstData(),
					advOrderData));

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

	private static PayAdvDelayedRefIntCess payAdvDelayedRefIntCessmapper(PayAdvScreenSpecCessDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvDelayedRefIntCess advDelayedRefIntCess = new PayAdvDelayedRefIntCess();
		advDelayedRefIntCess.setFeeCess(dto.getPayAdvDelayedRefInt().getFee());
		advDelayedRefIntCess.setIntrestCess(dto.getPayAdvDelayedRefInt().getIntrest());
		advDelayedRefIntCess.setOthersCess(dto.getPayAdvDelayedRefInt().getOthers());
		advDelayedRefIntCess.setPenaltyCess(dto.getPayAdvDelayedRefInt().getPenalty());
		advDelayedRefIntCess.setTaxCess(dto.getPayAdvDelayedRefInt().getTax());
		advDelayedRefIntCess.setTotCess(dto.getPayAdvDelayedRefInt().getTot());
		advDelayedRefIntCess.setRfdPaymentAdvOrderData(orderData);
		return advDelayedRefIntCess;

	}

	private static PayAdvNetRefAmntSacCess payAdvNetRefAmntSacCessMapper(PayAdvScreenSpecCessDataDto dto,
			RfdPaymentAdvOrderData orderData) {
		PayAdvNetRefAmntSacCess advNetRefAmntSacCess = new PayAdvNetRefAmntSacCess();
		advNetRefAmntSacCess.setFee(dto.getPayAdvNetRefAmntSac().getFee());
		advNetRefAmntSacCess.setIntrest(dto.getPayAdvNetRefAmntSac().getIntrest());
		advNetRefAmntSacCess.setOthers(dto.getPayAdvNetRefAmntSac().getOthers());
		advNetRefAmntSacCess.setPenalty(dto.getPayAdvNetRefAmntSac().getPenalty());
		advNetRefAmntSacCess.setTax(dto.getPayAdvNetRefAmntSac().getTax());
		advNetRefAmntSacCess.setTot(dto.getPayAdvNetRefAmntSac().getTot());
		advNetRefAmntSacCess.setRfdPaymentAdvOrderData(orderData);
		return advNetRefAmntSacCess;
	}

	private static PayAdvDelayedRefIntSgst payAdvDelayedRefIntSgstMapper(PayAdvScreenSpecSgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvDelayedRefIntSgst advNetRefAmntSacSgst = new PayAdvDelayedRefIntSgst();

		advNetRefAmntSacSgst.setFee(dto.getPayAdvDelayedRefInt().getFee());
		advNetRefAmntSacSgst.setIntrest(dto.getPayAdvDelayedRefInt().getIntrest());
		advNetRefAmntSacSgst.setOthers(dto.getPayAdvDelayedRefInt().getOthers());
		advNetRefAmntSacSgst.setPenalty(dto.getPayAdvDelayedRefInt().getPenalty());
		advNetRefAmntSacSgst.setTax(dto.getPayAdvDelayedRefInt().getTax());
		advNetRefAmntSacSgst.setTot(dto.getPayAdvDelayedRefInt().getTot());
		advNetRefAmntSacSgst.setRfdPaymentAdvOrderData(orderData);

		return advNetRefAmntSacSgst;
	}

	private static PayAdvNetRefAmntSacSgst payAdvNetRefAmntSacSgstMapper(PayAdvScreenSpecSgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvNetRefAmntSacSgst advNetRefAmntSacSgst = new PayAdvNetRefAmntSacSgst();
		advNetRefAmntSacSgst.setFee(dto.getPayAdvNetRefAmntSac().getFee());
		advNetRefAmntSacSgst.setIntrest(dto.getPayAdvNetRefAmntSac().getIntrest());
		advNetRefAmntSacSgst.setOthers(dto.getPayAdvNetRefAmntSac().getOthers());
		advNetRefAmntSacSgst.setPenalty(dto.getPayAdvNetRefAmntSac().getPenalty());
		advNetRefAmntSacSgst.setTax(dto.getPayAdvNetRefAmntSac().getTax());
		advNetRefAmntSacSgst.setTot(dto.getPayAdvNetRefAmntSac().getTot());
		advNetRefAmntSacSgst.setRfdPaymentAdvOrderData(orderData);

		return advNetRefAmntSacSgst;

	}

	private static PayAdvDelayedRefIntCgst payAdvDelayedRefIntCgstMapper(PayAdvScreenSpecCgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvDelayedRefIntCgst advDelayedRefIntCgst = new PayAdvDelayedRefIntCgst();

		advDelayedRefIntCgst.setFeeCgst(dto.getPayAdvDelayedRefInt().getFee());
		advDelayedRefIntCgst.setIntrestCgst(dto.getPayAdvDelayedRefInt().getIntrest());
		advDelayedRefIntCgst.setOthersCgst(dto.getPayAdvDelayedRefInt().getOthers());
		advDelayedRefIntCgst.setPenaltyCgst(dto.getPayAdvDelayedRefInt().getPenalty());
		advDelayedRefIntCgst.setTaxCgst(dto.getPayAdvDelayedRefInt().getTax());
		advDelayedRefIntCgst.setTotCgst(dto.getPayAdvDelayedRefInt().getTot());
		advDelayedRefIntCgst.setRfdPaymentAdvOrderData(orderData);

		return advDelayedRefIntCgst;

	}

	private static PayAdvNetRefAmntSacCgst payAdvNetRefAmntSacCgstMapper(PayAdvScreenSpecCgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {
		PayAdvNetRefAmntSacCgst advNetRefAmntSacCgst = new PayAdvNetRefAmntSacCgst();

		advNetRefAmntSacCgst.setFee(dto.getPayAdvNetRefAmntSac().getFee());
		advNetRefAmntSacCgst.setIntrest(dto.getPayAdvNetRefAmntSac().getIntrest());
		advNetRefAmntSacCgst.setOthers(dto.getPayAdvNetRefAmntSac().getOthers());
		advNetRefAmntSacCgst.setPenalty(dto.getPayAdvNetRefAmntSac().getPenalty());
		advNetRefAmntSacCgst.setTax(dto.getPayAdvNetRefAmntSac().getTax());
		advNetRefAmntSacCgst.setTot(dto.getPayAdvNetRefAmntSac().getTot());
		advNetRefAmntSacCgst.setRfdPaymentAdvOrderData(orderData);

		return advNetRefAmntSacCgst;
	}

	private static PayAdvDelayedRefIntIgst payAdvDelayedRefIntIgstMapper(PayAdvScreenSpecIgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvDelayedRefIntIgst advDelayedRefIntIgst = new PayAdvDelayedRefIntIgst();
		advDelayedRefIntIgst.setFee(dto.getPayAdvDelayedRefInt().getFee());
		advDelayedRefIntIgst.setIntrest(dto.getPayAdvDelayedRefInt().getIntrest());
		advDelayedRefIntIgst.setOthers(dto.getPayAdvDelayedRefInt().getOthers());
		advDelayedRefIntIgst.setPenalty(dto.getPayAdvDelayedRefInt().getPenalty());
		advDelayedRefIntIgst.setTax(dto.getPayAdvDelayedRefInt().getTax());
		advDelayedRefIntIgst.setTot(dto.getPayAdvDelayedRefInt().getTot());
		advDelayedRefIntIgst.setRfdPaymentAdvOrderData(orderData);

		return advDelayedRefIntIgst;

	}

	private static PayAdvNetRefAmntSacIgst payAdvNetRefAmntSacIgstMapper(PayAdvScreenSpecIgstDataDto dto,
			RfdPaymentAdvOrderData orderData) {

		PayAdvNetRefAmntSacIgst advNetRefAmntSacIgst = new PayAdvNetRefAmntSacIgst();

		advNetRefAmntSacIgst.setFee(dto.getPayAdvNetRefAmntSac().getFee());
		advNetRefAmntSacIgst.setIntrest(dto.getPayAdvNetRefAmntSac().getIntrest());
		advNetRefAmntSacIgst.setOthers(dto.getPayAdvNetRefAmntSac().getOthers());
		advNetRefAmntSacIgst.setPenalty(dto.getPayAdvNetRefAmntSac().getPenalty());
		advNetRefAmntSacIgst.setTax(dto.getPayAdvNetRefAmntSac().getTax());
		advNetRefAmntSacIgst.setTot(dto.getPayAdvNetRefAmntSac().getTot());
		advNetRefAmntSacIgst.setRfdPaymentAdvOrderData(orderData);

		return advNetRefAmntSacIgst;

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
		if (ObjectUtils.isEmpty(dto))
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
