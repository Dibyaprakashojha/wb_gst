package com.uneecops.common.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.InadmissibleAmounIGST_Dto;
import com.uneecops.common.dto.InadmissibleAmounSGST_Dto;
import com.uneecops.common.dto.InadmissibleAmountCGST_Dto;
import com.uneecops.common.dto.InadmissibleAmountcess_Dto;
import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.LedgerRecreditamountCGST_Dto;
import com.uneecops.common.dto.LedgerRecreditamountcess_Dto;
import com.uneecops.common.dto.LedgerRecreditamtIGST_Dto;
import com.uneecops.common.dto.LedgerRecreditamtSGST_Dto;
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
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.InadmissibleAmounIGST;
import com.uneecops.common.entity.InadmissibleAmounSGST;
import com.uneecops.common.entity.InadmissibleAmountCGST;
import com.uneecops.common.entity.InadmissibleAmountcess;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.LedgerRecreditamountCGST;
import com.uneecops.common.entity.LedgerRecreditamountcess;
import com.uneecops.common.entity.LedgerRecreditamtIGST;
import com.uneecops.common.entity.LedgerRecreditamtSGST;
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

public class RfdReplyMapper {

	public static Items mapRfdRepToEnt(RfdReplydto dto, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		
		Items item = setCommonValues(new Items() , rfdResponse);
		BeanUtils.copyProperties(dto, item);
		item.setRfdResponse(rfdResponse);
		item.setRfdReplyData(rfdRepdataMapper(dto.getRfdReplyData(), rfdResponse , item));
		return item;
	}

	public static List<Items> mapToEntityList(ItemDto itemDto, RfdResponse rfdResponse) {

		return itemDto.getRfdReply().stream().map(dto -> RfdReplyMapper.mapRfdRepToEnt(dto, rfdResponse))
				.collect(Collectors.toList());
	}

	private static RfdReplyData rfdRepdataMapper(RfdReplyDatadto dto , RfdResponse rfdResponse , Items item) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdReplyData repData = setCommonValues(new RfdReplyData() ,rfdResponse);
		BeanUtils.copyProperties(dto, repData);
		repData.setMaindocs(repMaindoc(dto.getMaindocs(), repData , rfdResponse));
		repData.setSuppdocs(repSuppDocMapper(dto.getSuppdocs(), repData , rfdResponse));
		repData.setDeclarationDetails(dataDeclarationDetMapper(dto.getDeclarationDetails(), repData , rfdResponse));
		repData.setPrsnlhrng(dataPersonalHiringdetMapper(dto.getPrsnlhrng(), repData ,rfdResponse));
		repData.setRplyextnreq(dataRplyextnreqMapper(dto.getRplyextnreq(), repData , rfdResponse));
		
		if(dto.getUndertakingAmtDtl() != null) {
			
			repData.setLedgerRecreditamountcess(ledgerRecreditamountcessMapper(
					dto.getUndertakingAmtDtl().getScreenSpeccess().getLedgerRecreditamtcess(), repData , rfdResponse));
			repData.setAmountcess(
					amountcessMapper(dto.getUndertakingAmtDtl().getScreenSpeccess().getInadmissibleAtcess(), repData , rfdResponse));
			repData.setLedgerRecreditamountCGST(ledgerRecrtamntCGSTMapper(
					dto.getUndertakingAmtDtl().getScreenspecificCGSTdata().getLedgerRecreditamtCGST(), repData , rfdResponse));
			repData.setAmountCGST(amountCGSTDtoMapper(
					dto.getUndertakingAmtDtl().getScreenspecificCGSTdata().getInadmissibleAtCGST(), repData , rfdResponse));
			repData.setLedgerRecreditamtIGST(recreditamtIGSTMapper(
					dto.getUndertakingAmtDtl().getScreenspecIGSTdata().getLdgrrecreditamt(), repData , rfdResponse));
			repData.setAmounIGST(
					inadmissibleAmounIGSTMapper(dto.getUndertakingAmtDtl().getScreenspecIGSTdata().getInadmamt(), repData , rfdResponse));
			repData.setLedgerRecreditamtSGST(
					recreditamtSGSTMapper(dto.getUndertakingAmtDtl().getScreenSpecSGST().getLdgrrecreditamt(), repData , rfdResponse));
			repData.setAmounSGST(inadmissibleAmounSGSTMapper(dto.getUndertakingAmtDtl().getScreenSpecSGST().getInadmamt() , repData , rfdResponse));
		}
		
		
		repData.setRepchangebankaccount(replychangebankaccountMapper(dto.getRepchangebankaccount() , repData , rfdResponse));
		repData.setScnReply(scnReplyMapper(dto.getScnReply() , repData , rfdResponse));
		repData.setItem(item);
		return repData;
	}

	private static ScnReply scnReplyMapper(ScnReply_Dto dto , RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		ScnReply reply = setCommonValues(new ScnReply() , rfdResponse);
		BeanUtils.copyProperties(dto, reply);
		reply.setRfdReplyData(repData);
		return reply;
	}

	private static Replychangebankaccount replychangebankaccountMapper(Replychangebankaccount_dto dto , RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		Replychangebankaccount replychangebankaccount = setCommonValues(new Replychangebankaccount() , rfdResponse);
		BeanUtils.copyProperties(dto, replychangebankaccount);
		replychangebankaccount.setRfdReplyData(repData);
		return replychangebankaccount;
	}

	private static LedgerRecreditamtSGST recreditamtSGSTMapper(LedgerRecreditamtSGST_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		LedgerRecreditamtSGST recreditamtSGST = setCommonValues(new LedgerRecreditamtSGST() , rfdResponse);
		BeanUtils.copyProperties(dto, recreditamtSGST);
		recreditamtSGST.setRfdReplyData(repData);
		return recreditamtSGST;
	}

	private static InadmissibleAmounSGST inadmissibleAmounSGSTMapper(InadmissibleAmounSGST_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		InadmissibleAmounSGST amounSGST = setCommonValues(new InadmissibleAmounSGST() , rfdResponse);
		BeanUtils.copyProperties(dto, amounSGST);
		amounSGST.setRfdReplyData(repData);
		return amounSGST;
	}

	private static LedgerRecreditamtIGST recreditamtIGSTMapper(LedgerRecreditamtIGST_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		LedgerRecreditamtIGST recreditamtIGST = setCommonValues(new LedgerRecreditamtIGST() , rfdResponse);
		BeanUtils.copyProperties(dto, recreditamtIGST);
		recreditamtIGST.setRfdReplyData(repData);
		return recreditamtIGST;
	}

	private static InadmissibleAmounIGST inadmissibleAmounIGSTMapper(InadmissibleAmounIGST_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		InadmissibleAmounIGST inadmissibleAmounIGST = setCommonValues(new InadmissibleAmounIGST() , rfdResponse);
		BeanUtils.copyProperties(dto, inadmissibleAmounIGST);
		inadmissibleAmounIGST.setRfdReplyData(repData);
		return inadmissibleAmounIGST;
	}

	private static InadmissibleAmountCGST amountCGSTDtoMapper(InadmissibleAmountCGST_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		InadmissibleAmountCGST amountCGST = setCommonValues(new InadmissibleAmountCGST() , rfdResponse);
		BeanUtils.copyProperties(dto, amountCGST);
		amountCGST.setRfdReplyData(repData);
		return amountCGST;
	}

	private static LedgerRecreditamountCGST ledgerRecrtamntCGSTMapper(LedgerRecreditamountCGST_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		LedgerRecreditamountCGST ledgerRecreditamountCGST = setCommonValues(new LedgerRecreditamountCGST() , rfdResponse);
		BeanUtils.copyProperties(dto, ledgerRecreditamountCGST);
		ledgerRecreditamountCGST.setRfdReplyData(repData);
		return ledgerRecreditamountCGST;
	}

	private static InadmissibleAmountcess amountcessMapper(InadmissibleAmountcess_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		InadmissibleAmountcess amountcess = setCommonValues(new InadmissibleAmountcess() , rfdResponse);

		BeanUtils.copyProperties(dto, amountcess);
		amountcess.setRfdReplyData(repData);
		return amountcess;
	}

	private static LedgerRecreditamountcess ledgerRecreditamountcessMapper(LedgerRecreditamountcess_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		LedgerRecreditamountcess ledgerRecreditamountcess = setCommonValues(new LedgerRecreditamountcess() , rfdResponse);
		BeanUtils.copyProperties(dto, ledgerRecreditamountcess);
		ledgerRecreditamountcess.setRfdReplyData(repData);
		return ledgerRecreditamountcess;
	}

	private static RedReplDataRplyextnreq dataRplyextnreqMapper(RedReplDataRplyextnreq_Dto dto, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RedReplDataRplyextnreq dataRplyextnreq = setCommonValues(new RedReplDataRplyextnreq() , rfdResponse);
		BeanUtils.copyProperties(dto, dataRplyextnreq);
		dataRplyextnreq.setRfdReplyData(repData);
		return dataRplyextnreq;
	}

	private static RfdRepDataPersonalHiringdet dataPersonalHiringdetMapper(RfdRepDataPersonalHiringdet_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdRepDataPersonalHiringdet dataPersonalHiringdet = setCommonValues(new RfdRepDataPersonalHiringdet() , rfdResponse);
		BeanUtils.copyProperties(dto, dataPersonalHiringdet);
		dataPersonalHiringdet.setRfdReplyData(repData);
		return dataPersonalHiringdet;
	}

	private static ReplDataDeclarationDet dataDeclarationDetMapper(ReplDataDeclarationDet_Dto dto,
			RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		ReplDataDeclarationDet dataDeclarationDet = setCommonValues(new ReplDataDeclarationDet() , rfdResponse);
		BeanUtils.copyProperties(dto, dataDeclarationDet);
		dataDeclarationDet.setRfdReplyData(repData);
		return dataDeclarationDet;
	}

	private static List<RepSuppDoc> repSuppDocMapper(List<RfdRepSuppDocDto> dtolist, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dtolist))
			return null;
		return dtolist.stream().map(dto -> {
			RepSuppDoc doc = setCommonValues(new RepSuppDoc() , rfdResponse);
			doc.setRfdReplyData(repData);
			doc.setDocName(dto.getDocName());
			doc.setDcupdtls(repSupDocdetMapper(dto.getDcupdtls(), doc ,  rfdResponse));
			return doc;
		}).collect(Collectors.toList());

	}

	private static RfdRepSuppDocDet repSupDocdetMapper(SuppDocumentDetailsDto dto, RepSuppDoc doc ,RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RfdRepSuppDocDet det = setCommonValues(new RfdRepSuppDocDet() ,  rfdResponse);
		BeanUtils.copyProperties(dto, det);
		det.setRepSuppDoc(doc);
		return det;
	}

	private static List<RepmainDoc> repMaindoc(List<RepmainDocdto> dtoList, RfdReplyData repData, RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dtoList))
			return null;
//		RepmainDoc repMaindoc = new RepmainDoc();
//		BeanUtils.copyProperties(dto, repMaindoc);
		return dtoList.stream().map(dto -> {
			RepmainDoc repMaindoc = setCommonValues(new RepmainDoc() , rfdResponse);
			repMaindoc.setRfdReplyData(repData);
			BeanUtils.copyProperties(dto, repMaindoc);
			repMaindoc.setRepSuppDocumentDetails(detailsMapper(dto.getDcupdtls(), repMaindoc ,  rfdResponse));
			return repMaindoc;
		}).collect(Collectors.toList());
	}

	private static RepSuppDocumentDetails detailsMapper(SuppDocumentDetailsDto dto, RepmainDoc repMaindoc , RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto))
			return null;
		RepSuppDocumentDetails details = setCommonValues(new RepSuppDocumentDetails() , rfdResponse);
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
