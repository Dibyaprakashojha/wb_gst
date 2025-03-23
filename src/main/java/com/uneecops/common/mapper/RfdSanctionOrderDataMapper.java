package com.uneecops.common.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.AdjustedDemandDet_Dto;
import com.uneecops.common.dto.CommonAmountDetForAllDto;
import com.uneecops.common.dto.CommonDocDetails_Dto;
import com.uneecops.common.dto.CommonStatementRefundClaimDto;
import com.uneecops.common.dto.CommonTaxOfficerDet_Dto;
import com.uneecops.common.dto.DemandAdjustedCess_Dto;
import com.uneecops.common.dto.DemandAdjustedCgst_Dto;
import com.uneecops.common.dto.DemandAdjustedIgst_Dto;
import com.uneecops.common.dto.DemandAdjustedSgst_Dto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.RefAmtScreenData_Dto;
import com.uneecops.common.dto.RfdSanctionOrderData_Dto;
import com.uneecops.common.dto.SanctionOrderDet_Dto;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.DemandAdjustedCess;
import com.uneecops.common.entity.DemandAdjustedCgst;
import com.uneecops.common.entity.DemandAdjustedIgst;
import com.uneecops.common.entity.DemandAdjustedSgst;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.RfdSanOrdDataDocDet;
import com.uneecops.common.entity.RfdSanOrdTODet;
import com.uneecops.common.entity.SanctionAmntDetails;
import com.uneecops.common.entity.SanctionOrderDet;
import com.uneecops.common.enums.SanctionAmount;

public class RfdSanctionOrderDataMapper {

	public static Items mapToEntity(ItemDto itemDto, RfdResponse rfdResponse) {

		Items item = new Items();

		RfdSanctionOrderData_Dto dto = itemDto.getRfdSanOrderData();
		List<AdjustedDemandDet_Dto> dtolist = dto.getScrnSpecDetSanctionOrderData().getSanctionOrderDet()
				.getAdjustedDemDet();
		item.setSanctionOrderDet(sanctionOrderDetMapper(dto.getScrnSpecDetSanctionOrderData().getSanctionOrderDet(),
				item, dtolist, rfdResponse , dto));

//		set item
		BeanUtils.copyProperties(itemDto, item);
		item.setRfdResponse(rfdResponse);
		item.setCrn(rfdResponse.getCrn());
		item.setGstin(rfdResponse.getGstin());
		// sanctionOrderData.setItems(item);
		return item;
	}

	private static SanctionOrderDet sanctionOrderDetMapper(SanctionOrderDet_Dto dto, Items item,
			List<AdjustedDemandDet_Dto> dtolist, RfdResponse rfdResponse , RfdSanctionOrderData_Dto dataDto) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		SanctionOrderDet orderDet = setCommonValues(new SanctionOrderDet(), rfdResponse);
		BeanUtils.copyProperties(dto, orderDet);
		dtolist = dto.getAdjustedDemDet();
		if (!CollectionUtils.isEmpty(dtolist)) {
			List<DemandAdjustedCess> demandAdjustedCess = new ArrayList<>();
			List<DemandAdjustedCgst> demandAdjustedCgst = new ArrayList<>();
			List<DemandAdjustedIgst> demandAdjustedIgst = new ArrayList<>();
			List<DemandAdjustedSgst> demandAdjustedSgst = new ArrayList<>();
			for (int i = 0; i < dtolist.size(); i++) {

				if (dtolist.get(i).getDemandAdjustedCess() != null) {
					DemandAdjustedCess adjustedCess = new DemandAdjustedCess();
					adjustedCessMapper(dtolist.get(i).getDemandAdjustedCess(), adjustedCess);
					adjustedCess.setAdjustedDemOrderId(dtolist.get(i).getAdjustedDemOrderId());
					adjustedCess.setSanctionOrderDet(orderDet);
					demandAdjustedCess.add(adjustedCess);

				}
				if (dtolist.get(i).getDemandAdjustedCgst() != null) {
					DemandAdjustedCgst adjustedCgst = new DemandAdjustedCgst();
					adjustedCgstMapper(dtolist.get(i).getDemandAdjustedCgst(), adjustedCgst);
					adjustedCgst.setAdjustedDemOrderId(dtolist.get(i).getAdjustedDemOrderId());
					adjustedCgst.setSanctionOrderDet(orderDet);
					demandAdjustedCgst.add(adjustedCgst);

				}
				if (dtolist.get(i).getDemandAdjustedIgst() != null) {
					DemandAdjustedIgst adjustedIgst = new DemandAdjustedIgst();
					adjustedIgstMapper(dtolist.get(i).getDemandAdjustedIgst(), adjustedIgst);
					adjustedIgst.setAdjustedDemOrderId(dtolist.get(i).getAdjustedDemOrderId());
					adjustedIgst.setSanctionOrderDet(orderDet);
					demandAdjustedIgst.add(adjustedIgst);
				}
				if (dtolist.get(i).getDemandAdjustedSgst() != null) {

					DemandAdjustedSgst adjustedSgst = new DemandAdjustedSgst();
					adjustedSgstMapper(dtolist.get(i).getDemandAdjustedSgst(), adjustedSgst);
					adjustedSgst.setAdjustedDemOrderId(dtolist.get(i).getAdjustedDemOrderId());
					adjustedSgst.setSanctionOrderDet(orderDet);
					demandAdjustedSgst.add(adjustedSgst);
				}
			}
			orderDet.setDemandAdjustedCess(demandAdjustedCess);
			orderDet.setDemandAdjustedCgst(demandAdjustedCgst);
			orderDet.setDemandAdjustedIgst(demandAdjustedIgst);
			orderDet.setDemandAdjustedSgst(demandAdjustedSgst);

		}

//		orderDet.setScrnSpecIGSTData(scrnSpecIGSTDataMapper(dto.getRefAmtScreenData().getScrnSpecIGSTData(), orderDet));
//		orderDet.setScrnSpecCGSTData(scrnSpecCGSTDataMapper(dto.getRefAmtScreenData().getScrnSpecCGSTData(), orderDet));
//		orderDet.setScrnSpecCESSData(cessDataMapper(dto.getRefAmtScreenData().getScrnSpecCESSData(), orderDet));
//		orderDet.setScrnSpecSGSTData(scrnSpecSGSTDataMapper(dto.getRefAmtScreenData().getScrnSpecSGSTData(), orderDet));
		orderDet.setCommonDocDetails(sanOrdDataDocDetsMapper(dataDto.getCommonDocDetails(), orderDet , rfdResponse));
		orderDet.setCommonTaxOfficerDet(sanOrdTODetMapper(dataDto.getCommonTaxOfficerDet(),  orderDet ,rfdResponse));
		orderDet.setSanctionAmntDetails(sanctionAmntDetailsMapper(dto,orderDet , rfdResponse));
		orderDet.setItems(item);
		return orderDet;
	}

	private static DemandAdjustedCess adjustedCessMapper(DemandAdjustedCess_Dto dto, DemandAdjustedCess adjustedCess) {

		adjustedCess.setCessFee(dto.getDemAdjCess_Cess().getFee());
		adjustedCess.setCessIntrest(dto.getDemAdjCess_Cess().getIntrest());
		adjustedCess.setCessOthers(dto.getDemAdjCess_Cess().getOthers());
		adjustedCess.setCessPenalty(dto.getDemAdjCess_Cess().getPenalty());
		adjustedCess.setCessTax(dto.getDemAdjCess_Cess().getTax());
		adjustedCess.setCessTot(dto.getDemAdjCess_Cess().getTot());

		adjustedCess.setCgstFee(dto.getDemAdjCess_Cgst().getFee());
		adjustedCess.setCgstIntrest(dto.getDemAdjCess_Cgst().getIntrest());
		adjustedCess.setCgstOthers(dto.getDemAdjCess_Cgst().getOthers());
		adjustedCess.setCgstPenalty(dto.getDemAdjCess_Cgst().getPenalty());
		adjustedCess.setCgstTax(dto.getDemAdjCess_Cgst().getTax());
		adjustedCess.setCgstTot(dto.getDemAdjCess_Cgst().getTot());

		adjustedCess.setIgstFee(dto.getDemAdjCess_Igst().getFee());
		adjustedCess.setIgstIntrest(dto.getDemAdjCess_Igst().getIntrest());
		adjustedCess.setIgstOthers(dto.getDemAdjCess_Igst().getOthers());
		adjustedCess.setIgstPenalty(dto.getDemAdjCess_Igst().getPenalty());
		adjustedCess.setIgstTax(dto.getDemAdjCess_Igst().getTax());
		adjustedCess.setIgstTot(dto.getDemAdjCess_Igst().getTot());

		adjustedCess.setSgstFee(dto.getDemAdjCess_Sgst().getFee());
		adjustedCess.setSgstIntrest(dto.getDemAdjCess_Sgst().getIntrest());
		adjustedCess.setSgstOthers(dto.getDemAdjCess_Sgst().getOthers());
		adjustedCess.setSgstPenalty(dto.getDemAdjCess_Sgst().getPenalty());
		adjustedCess.setSgstTax(dto.getDemAdjCess_Sgst().getTax());
		adjustedCess.setSgstTot(dto.getDemAdjCess_Sgst().getTot());

		return adjustedCess;
	}

	private static DemandAdjustedCgst adjustedCgstMapper(DemandAdjustedCgst_Dto dto, DemandAdjustedCgst adjustedCgst) {
		if (ObjectUtils.isEmpty(dto))
			return null;

		adjustedCgst.setCessFee(dto.getDemAdjCgst_Cess().getFee());
		adjustedCgst.setCessIntrest(dto.getDemAdjCgst_Cess().getIntrest());
		adjustedCgst.setCessOthers(dto.getDemAdjCgst_Cess().getOthers());
		adjustedCgst.setCessPenalty(dto.getDemAdjCgst_Cess().getPenalty());
		adjustedCgst.setCessTax(dto.getDemAdjCgst_Cess().getTax());
		adjustedCgst.setCessTot(dto.getDemAdjCgst_Cess().getTot());

		adjustedCgst.setCgstFee(dto.getDemAdjCgst_Cgst().getFee());
		adjustedCgst.setCgstIntrest(dto.getDemAdjCgst_Cgst().getIntrest());
		adjustedCgst.setCgstOthers(dto.getDemAdjCgst_Cgst().getOthers());
		adjustedCgst.setCgstPenalty(dto.getDemAdjCgst_Cgst().getPenalty());
		adjustedCgst.setCgstTax(dto.getDemAdjCgst_Cgst().getTax());
		adjustedCgst.setCgstTot(dto.getDemAdjCgst_Cgst().getTot());

		adjustedCgst.setIgstFee(dto.getDemAdjCgst_Igst().getFee());
		adjustedCgst.setIgstIntrest(dto.getDemAdjCgst_Igst().getIntrest());
		adjustedCgst.setIgstOthers(dto.getDemAdjCgst_Igst().getOthers());
		adjustedCgst.setIgstPenalty(dto.getDemAdjCgst_Igst().getPenalty());
		adjustedCgst.setIgstTax(dto.getDemAdjCgst_Igst().getTax());
		adjustedCgst.setIgstTot(dto.getDemAdjCgst_Igst().getTot());

		adjustedCgst.setSgstFee(dto.getDemAdjCgst_Sgst().getFee());
		adjustedCgst.setSgstIntrest(dto.getDemAdjCgst_Sgst().getIntrest());
		adjustedCgst.setSgstOthers(dto.getDemAdjCgst_Sgst().getOthers());
		adjustedCgst.setSgstPenalty(dto.getDemAdjCgst_Sgst().getPenalty());
		adjustedCgst.setSgstTax(dto.getDemAdjCgst_Sgst().getTax());
		adjustedCgst.setSgstTot(dto.getDemAdjCgst_Sgst().getTot());

		return adjustedCgst;
	}

	private static DemandAdjustedSgst adjustedSgstMapper(DemandAdjustedSgst_Dto dto, DemandAdjustedSgst adjustedSgst) {
		if (ObjectUtils.isEmpty(dto))
			return null;

		adjustedSgst.setCessFee(dto.getDemAdjSgst_Cess().getFee());
		adjustedSgst.setCessIntrest(dto.getDemAdjSgst_Cess().getIntrest());
		adjustedSgst.setCessOthers(dto.getDemAdjSgst_Cess().getOthers());
		adjustedSgst.setCessPenalty(dto.getDemAdjSgst_Cess().getPenalty());
		adjustedSgst.setCessTax(dto.getDemAdjSgst_Cess().getTax());
		adjustedSgst.setCessTot(dto.getDemAdjSgst_Cess().getTot());

		adjustedSgst.setCgstFee(dto.getDemAdjSgst_Cgst().getFee());
		adjustedSgst.setCgstIntrest(dto.getDemAdjSgst_Cgst().getIntrest());
		adjustedSgst.setCgstOthers(dto.getDemAdjSgst_Cgst().getOthers());
		adjustedSgst.setCgstPenalty(dto.getDemAdjSgst_Cgst().getPenalty());
		adjustedSgst.setCgstTax(dto.getDemAdjSgst_Cgst().getTax());
		adjustedSgst.setCgstTot(dto.getDemAdjSgst_Cgst().getTot());

		adjustedSgst.setIgstFee(dto.getDemAdjSgst_Igst().getFee());
		adjustedSgst.setIgstIntrest(dto.getDemAdjSgst_Igst().getIntrest());
		adjustedSgst.setIgstOthers(dto.getDemAdjSgst_Igst().getOthers());
		adjustedSgst.setIgstPenalty(dto.getDemAdjSgst_Igst().getPenalty());
		adjustedSgst.setIgstTax(dto.getDemAdjSgst_Igst().getTax());
		adjustedSgst.setIgstTot(dto.getDemAdjSgst_Igst().getTot());

		adjustedSgst.setSgstFee(dto.getDemAdjSgst_Sgst().getFee());
		adjustedSgst.setSgstIntrest(dto.getDemAdjSgst_Sgst().getIntrest());
		adjustedSgst.setSgstOthers(dto.getDemAdjSgst_Sgst().getOthers());
		adjustedSgst.setSgstPenalty(dto.getDemAdjSgst_Sgst().getPenalty());
		adjustedSgst.setSgstTax(dto.getDemAdjSgst_Sgst().getTax());
		adjustedSgst.setSgstTot(dto.getDemAdjSgst_Sgst().getTot());

		return adjustedSgst;
	}

	private static DemandAdjustedIgst adjustedIgstMapper(DemandAdjustedIgst_Dto dto, DemandAdjustedIgst adjustedIgst) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		adjustedIgst.setCessFee(dto.getDemAdjIgst_Cess().getFee());
		adjustedIgst.setCessIntrest(dto.getDemAdjIgst_Cess().getIntrest());
		adjustedIgst.setCessOthers(dto.getDemAdjIgst_Cess().getOthers());
		adjustedIgst.setCessPenalty(dto.getDemAdjIgst_Cess().getPenalty());
		adjustedIgst.setCessTax(dto.getDemAdjIgst_Cess().getTax());
		adjustedIgst.setCessTot(dto.getDemAdjIgst_Cess().getTot());

		adjustedIgst.setCgstFee(dto.getDemAdjIgst_Cgst().getFee());
		adjustedIgst.setCgstIntrest(dto.getDemAdjIgst_Cgst().getIntrest());
		adjustedIgst.setCgstOthers(dto.getDemAdjIgst_Cgst().getOthers());
		adjustedIgst.setCgstPenalty(dto.getDemAdjIgst_Cgst().getPenalty());
		adjustedIgst.setCgstTax(dto.getDemAdjIgst_Cgst().getTax());
		adjustedIgst.setCgstTot(dto.getDemAdjIgst_Cgst().getTot());

		adjustedIgst.setIgstFee(dto.getDemAdjIgst_Igst().getFee());
		adjustedIgst.setIgstIntrest(dto.getDemAdjIgst_Igst().getIntrest());
		adjustedIgst.setIgstOthers(dto.getDemAdjIgst_Igst().getOthers());
		adjustedIgst.setIgstPenalty(dto.getDemAdjIgst_Igst().getPenalty());
		adjustedIgst.setIgstTax(dto.getDemAdjIgst_Igst().getTax());
		adjustedIgst.setIgstTot(dto.getDemAdjIgst_Igst().getTot());

		adjustedIgst.setSgstFee(dto.getDemAdjIgst_Sgst().getFee());
		adjustedIgst.setSgstIntrest(dto.getDemAdjIgst_Sgst().getIntrest());
		adjustedIgst.setSgstOthers(dto.getDemAdjIgst_Sgst().getOthers());
		adjustedIgst.setSgstPenalty(dto.getDemAdjIgst_Sgst().getPenalty());
		adjustedIgst.setSgstTax(dto.getDemAdjIgst_Sgst().getTax());
		adjustedIgst.setSgstTot(dto.getDemAdjIgst_Sgst().getTot());
		return adjustedIgst;
	}

	 public static SanctionAmntDetails
	 sanctionAmntDetailsMapper(SanctionOrderDet_Dto dto, SanctionOrderDet sanctionOrderDet , RfdResponse response) {
	        if (dto == null || dto.getRefAmtScreenData() == null) {
	            return null;
	        }

	        RefAmtScreenData_Dto amtScreenData = dto.getRefAmtScreenData();
//	        SanctionAmntDetails entity = null;
	        SanctionAmntDetails entity = setCommonValues(new SanctionAmntDetails() , response);
		        entity.setSanctionOrderDet(sanctionOrderDet);

		        // Map IGST values
		        if (amtScreenData.getScrnSpecIGSTData() != null) {
		            mapTaxDetails(entity, amtScreenData.getScrnSpecIGSTData(), "igst");
		        }

		        // Map CGST values
		        if (amtScreenData.getScrnSpecCGSTData() != null) {
		            mapTaxDetails(entity, amtScreenData.getScrnSpecCGSTData(), "cgst");
		        }

		        // Map SGST values
		        if (amtScreenData.getScrnSpecSGSTData() != null) {
		            mapTaxDetails(entity, amtScreenData.getScrnSpecSGSTData(), "sgst");
		        }

		        // Map CESS values
		         if (amtScreenData.getScrnSpecCESSData() != null) {
		            mapTaxDetails(entity, amtScreenData.getScrnSpecCESSData(), "cess");
		        }
	        
	        return entity;
	    }

	    private static void mapTaxDetails(SanctionAmntDetails entity, CommonAmountDetForAllDto dto, String taxType) {
	        if (dto == null) return;

	        entity.setSancAmntType(SanctionAmount.CLAIMEDAMNT);
	        setTaxValues(entity, dto.getClaimedAmt(), taxType);

	        entity.setSancAmntType(SanctionAmount.PROVISIONALAMNT);
	        setTaxValues(entity, dto.getProvamt(), taxType);

	        entity.setSancAmntType(SanctionAmount.INADMISSABLEAMNT);
	        setTaxValues(entity, dto.getInadmissableamt(), taxType);

	        entity.setSancAmntType(SanctionAmount.GROSSAMNT);
	        setTaxValues(entity, dto.getGrossamt(), taxType);

	        entity.setSancAmntType(SanctionAmount.ADJUSTEDAMNT);
	        setTaxValues(entity, dto.getAdjustedamt(), taxType);

	        entity.setSancAmntType(SanctionAmount.NETAMNT);
	        setTaxValues(entity, dto.getNetamt(), taxType);

	        entity.setSancAmntType(SanctionAmount.RECOVEREDAMNT);
	        setTaxValues(entity, dto.getRecoveredAmt(), taxType);

	        entity.setSancAmntType(SanctionAmount.CWFINITIATEDAMNT);
	        setTaxValues(entity, dto.getCwfamt(), taxType);
	    }

	    private static void setTaxValues(SanctionAmntDetails entity, CommonStatementRefundClaimDto dto, String taxType) {
	        if (dto == null) return;

	        switch (taxType.toLowerCase()) {
	            case "igst":
	                entity.setIgstIntrest(dto.getIntrest());
	                entity.setIgstOthers(dto.getOthers());
	                entity.setIgstFee(dto.getFee());
	                entity.setIgstPenalty(dto.getPenalty());
	                entity.setIgstTax(dto.getTax());
	                entity.setIgstTot(dto.getTot());
	                break;
	            case "cgst":
	                entity.setCgstIntrest(dto.getIntrest());
	                entity.setCgstOthers(dto.getOthers());
	                entity.setCgstFee(dto.getFee());
	                entity.setCgstPenalty(dto.getPenalty());
	                entity.setCgstTax(dto.getTax());
	                entity.setCgstTot(dto.getTot());
	                break;
	            case "sgst":
	                entity.setSgstIntrest(dto.getIntrest());
	                entity.setSgstOthers(dto.getOthers());
	                entity.setSgstFee(dto.getFee());
	                entity.setSgstPenalty(dto.getPenalty());
	                entity.setSgstTax(dto.getTax());
	                entity.setSgstTot(dto.getTot());
	                break;
	            case "cess":
	                entity.setCessIntrest(dto.getIntrest());
	                entity.setCessOthers(dto.getOthers());
	                entity.setCessFee(dto.getFee());
	                entity.setCessPenalty(dto.getPenalty());
	                entity.setCessTax(dto.getTax());
	                entity.setCessTot(dto.getTot());
	                break;
	        }
	    }
	private static RfdSanOrdTODet sanOrdTODetMapper(CommonTaxOfficerDet_Dto dto, SanctionOrderDet orderDet , RfdResponse response) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdSanOrdTODet rfdSanOrdTODet = setCommonValues(new RfdSanOrdTODet() , response);
		BeanUtils.copyProperties(dto, rfdSanOrdTODet);
		rfdSanOrdTODet.setSanctionOrderDet(orderDet);
		return rfdSanOrdTODet;
	}

	private static List<RfdSanOrdDataDocDet> sanOrdDataDocDetsMapper(List<CommonDocDetails_Dto> dtoList, SanctionOrderDet orderDet , RfdResponse response) {
		if (ObjectUtils.isEmpty(dtoList))
			return null;
		return dtoList.stream().map(dto -> {
			RfdSanOrdDataDocDet dataDocDet = setCommonValues(new RfdSanOrdDataDocDet() , response);
			BeanUtils.copyProperties(dto, dataDocDet);
			dataDocDet.setSanctionOrderDet(orderDet);
			return dataDocDet;
		}).collect(Collectors.toList());
	}

	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
		entity.setGstin(rfdResponse.getGstin());
		entity.setCrn(rfdResponse.getCrn());
		return entity;
	}
}
