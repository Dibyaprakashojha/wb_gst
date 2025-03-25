package com.uneecops.common.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.CommonStatementRefundClaimDto;
import com.uneecops.common.dto.CommonUnderTakingAmntDto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.RedReplDataRplyextnreq_Dto;
import com.uneecops.common.dto.ReplDataDeclarationDet_Dto;
import com.uneecops.common.dto.Replychangebankaccount_dto;
import com.uneecops.common.dto.RepmainDocdto;
import com.uneecops.common.dto.RfdRepDataPersonalHiringdet_Dto;
import com.uneecops.common.dto.RfdRepSuppDocDto;
import com.uneecops.common.dto.RfdReplyDatadto;
import com.uneecops.common.dto.RfdReplydto;
import com.uneecops.common.dto.ScnReply_Dto;
import com.uneecops.common.dto.SuppDocumentDetailsDto;
import com.uneecops.common.dto.UndertakingAmtDetails_Dto;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.RedReplDataRplyextnreq;
import com.uneecops.common.entity.RepSuppDoc;
import com.uneecops.common.entity.RepSuppDocumentDetails;
import com.uneecops.common.entity.ReplDataDeclarationDet;
import com.uneecops.common.entity.Replychangebankaccount;
import com.uneecops.common.entity.RepmainDoc;
import com.uneecops.common.entity.RfdRepDataPersonalHiringdet;
import com.uneecops.common.entity.RfdRepSuppDocDet;
import com.uneecops.common.entity.RfdReplyData;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.ScnReply;
import com.uneecops.common.entity.UndertakingAmtDetails;
import com.uneecops.common.enums.TaxType;
import com.uneecops.common.enums.UnderTakingAmount;

public class RfdReplyMapper {

	public static Items mapRfdRepToEnt(RfdReplydto dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;

		Items item = setCommonValues(new Items(), rfdResponse);
		BeanUtils.copyProperties(dto, item);
		item.setRfdResponse(rfdResponse);
		item.setRfdReplyData(rfdRepdataMapper(dto.getRfdReplyData(), rfdResponse, item));
		return item;
	}

	public static List<Items> mapToEntityList(ItemDto itemDto, RfdResponse rfdResponse) {

		return itemDto.getRfdReply().stream().map(dto -> RfdReplyMapper.mapRfdRepToEnt(dto, rfdResponse))
				.collect(Collectors.toList());
	}

	private static RfdReplyData rfdRepdataMapper(RfdReplyDatadto dto, RfdResponse rfdResponse, Items item) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdReplyData repData = setCommonValues(new RfdReplyData(), rfdResponse);
		BeanUtils.copyProperties(dto, repData);
		repData.setMaindocs(repMaindoc(dto.getMaindocs(), repData, rfdResponse));
		repData.setSuppdocs(repSuppDocMapper(dto.getSuppdocs(), repData, rfdResponse));
		repData.setDeclarationDetails(dataDeclarationDetMapper(dto.getDeclarationDetails(), repData, rfdResponse));
		repData.setPrsnlhrng(dataPersonalHiringdetMapper(dto.getPrsnlhrng(), repData, rfdResponse));
		repData.setRplyextnreq(dataRplyextnreqMapper(dto.getRplyextnreq(), repData, rfdResponse));

		if (dto.getUndertakingAmtDtl() != null) {
			repData.setUndertakingAmtDtl(undertakingAmtDetailsMapper(repData, dto.getUndertakingAmtDtl(), rfdResponse));
			repData.setUndertakingNil(dto.getUndertakingAmtDtl().getUndertakingNil());
		}

		repData.setRepchangebankaccount(
				replychangebankaccountMapper(dto.getRepchangebankaccount(), repData, rfdResponse));
		repData.setScnReply(scnReplyMapper(dto.getScnReply(), repData, rfdResponse));
		repData.setItem(item);
		return repData;
	}

	private static List<UndertakingAmtDetails> undertakingAmtDetailsMapper(RfdReplyData replyData,
			UndertakingAmtDetails_Dto details_Dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(details_Dto))
			return null;

		List<UndertakingAmtDetails> undertakingAmtDetailList = new ArrayList<>();

		for (UnderTakingAmount ammountType : UnderTakingAmount.values()) {
			UndertakingAmtDetails undertakingAmtDetails = new UndertakingAmtDetails();
			setCommonValues(undertakingAmtDetails, rfdResponse);
			undertakingAmtDetails.setRfdReplyData(replyData);
			undertakingAmtDetails.setUnderTakingAmount(ammountType);

			combineTaxValues(details_Dto.getScreenspecIGSTdata(), undertakingAmtDetails, TaxType.IGST, ammountType);
			combineTaxValues(details_Dto.getScreenspecificCGSTdata(), undertakingAmtDetails, TaxType.CGST, ammountType);
			combineTaxValues(details_Dto.getScreenSpecSGST(), undertakingAmtDetails, TaxType.SGST, ammountType);
			combineTaxValues(details_Dto.getScreenSpeccess(), undertakingAmtDetails, TaxType.CESS, ammountType);

			undertakingAmtDetailList.add(undertakingAmtDetails);
		}

		return undertakingAmtDetailList;

	}

	private static void combineTaxValues(CommonUnderTakingAmntDto amntDto, UndertakingAmtDetails undertakingAmtDetails,
			TaxType taxType, UnderTakingAmount amountType) {
		if (amntDto == null)
			return;

		// Select the correct sanction amount type data
		CommonStatementRefundClaimDto undAmntData = switch (amountType) {
		case INADMISSIBLEAMNT -> amntDto.getInadmamt();
		case LEDGERRECREDITAMNT -> amntDto.getLdgrrecreditamt();
		};

		if (undAmntData != null) {
			setCombinedTaxValues(undertakingAmtDetails, undAmntData, taxType);
		}
	}

	private static BigDecimal safeAdd(BigDecimal a, BigDecimal b) {
		return (a != null ? a : BigDecimal.ZERO).add(b != null ? b : BigDecimal.ZERO);
	}

	private static void setCombinedTaxValues(UndertakingAmtDetails entity, CommonStatementRefundClaimDto dto,
			TaxType taxType) {
		if (dto == null)
			return;
		switch (taxType) {
		case IGST -> {
			entity.setIgstIntrest(safeAdd(entity.getIgstIntrest(), dto.getIntrest()));
			entity.setIgstOthers(safeAdd(entity.getIgstOthers(), dto.getOthers()));
			entity.setIgstFee(safeAdd(entity.getIgstFee(), dto.getFee()));
			entity.setIgstPenalty(safeAdd(entity.getIgstPenalty(), dto.getPenalty()));
			entity.setIgsTtax(safeAdd(entity.getIgsTtax(), dto.getTax()));
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

	private static ScnReply scnReplyMapper(ScnReply_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		ScnReply reply = setCommonValues(new ScnReply(), rfdResponse);
		BeanUtils.copyProperties(dto, reply);
		reply.setRfdReplyData(repData);
		return reply;
	}

	private static Replychangebankaccount replychangebankaccountMapper(Replychangebankaccount_dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		Replychangebankaccount replychangebankaccount = setCommonValues(new Replychangebankaccount(), rfdResponse);
		BeanUtils.copyProperties(dto, replychangebankaccount);
		replychangebankaccount.setRfdReplyData(repData);
		return replychangebankaccount;
	}

	private static RedReplDataRplyextnreq dataRplyextnreqMapper(RedReplDataRplyextnreq_Dto dto, RfdReplyData repData,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RedReplDataRplyextnreq dataRplyextnreq = setCommonValues(new RedReplDataRplyextnreq(), rfdResponse);
		BeanUtils.copyProperties(dto, dataRplyextnreq);
		dataRplyextnreq.setRfdReplyData(repData);
		return dataRplyextnreq;
	}

	private static RfdRepDataPersonalHiringdet dataPersonalHiringdetMapper(RfdRepDataPersonalHiringdet_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdRepDataPersonalHiringdet dataPersonalHiringdet = setCommonValues(new RfdRepDataPersonalHiringdet(),
				rfdResponse);
		BeanUtils.copyProperties(dto, dataPersonalHiringdet);
		dataPersonalHiringdet.setRfdReplyData(repData);
		return dataPersonalHiringdet;
	}

	private static ReplDataDeclarationDet dataDeclarationDetMapper(ReplDataDeclarationDet_Dto dto, RfdReplyData repData,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		ReplDataDeclarationDet dataDeclarationDet = setCommonValues(new ReplDataDeclarationDet(), rfdResponse);
		BeanUtils.copyProperties(dto, dataDeclarationDet);
		dataDeclarationDet.setRfdReplyData(repData);
		return dataDeclarationDet;
	}

	private static List<RepSuppDoc> repSuppDocMapper(List<RfdRepSuppDocDto> dtolist, RfdReplyData repData,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dtolist))
			return null;
		return dtolist.stream().map(dto -> {
			RepSuppDoc doc = setCommonValues(new RepSuppDoc(), rfdResponse);
			doc.setRfdReplyData(repData);
			doc.setDocName(dto.getDocName());
			doc.setDcupdtls(repSupDocdetMapper(dto.getDcupdtls(), doc, rfdResponse));
			return doc;
		}).collect(Collectors.toList());

	}

	private static RfdRepSuppDocDet repSupDocdetMapper(SuppDocumentDetailsDto dto, RepSuppDoc doc,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdRepSuppDocDet det = setCommonValues(new RfdRepSuppDocDet(), rfdResponse);
		BeanUtils.copyProperties(dto, det);
		det.setRepSuppDoc(doc);
		return det;
	}

	private static List<RepmainDoc> repMaindoc(List<RepmainDocdto> dtoList, RfdReplyData repData,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dtoList))
			return null;
//		RepmainDoc repMaindoc = new RepmainDoc();
//		BeanUtils.copyProperties(dto, repMaindoc);
		return dtoList.stream().map(dto -> {
			RepmainDoc repMaindoc = setCommonValues(new RepmainDoc(), rfdResponse);
			repMaindoc.setRfdReplyData(repData);
			BeanUtils.copyProperties(dto, repMaindoc);
			repMaindoc.setRepSuppDocumentDetails(detailsMapper(dto.getDcupdtls(), repMaindoc, rfdResponse));
			return repMaindoc;
		}).collect(Collectors.toList());
	}

	private static RepSuppDocumentDetails detailsMapper(SuppDocumentDetailsDto dto, RepmainDoc repMaindoc,
			RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RepSuppDocumentDetails details = setCommonValues(new RepSuppDocumentDetails(), rfdResponse);
		BeanUtils.copyProperties(dto, details);
		details.setRepmainDoc(repMaindoc);
		return details;
	}

	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
		entity.setGstin(rfdResponse.getGstin());
		entity.setCrn(rfdResponse.getCrn());
		return entity;
	}
}
