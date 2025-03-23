package com.uneecops.common.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.uneecops.common.dto.ItemDto;
import com.uneecops.common.dto.NoticeDataDocumentDetailsDto;
import com.uneecops.common.dto.RfdNoticedto;
import com.uneecops.common.dto.ScreenDetailsdto;
import com.uneecops.common.entity.CommonEntityForAll;
import com.uneecops.common.entity.InadmissibleRsnSCN;
import com.uneecops.common.entity.Items;
import com.uneecops.common.entity.NoticeDataDocumentDetails;
import com.uneecops.common.entity.NoticeDataSuppDoc;
import com.uneecops.common.entity.NoticeDataTaxOfficerDet;
import com.uneecops.common.entity.NtcChngeBnkAcc;
import com.uneecops.common.entity.NtcPersonalHearingDtls;
import com.uneecops.common.entity.RfdNoticeData;
import com.uneecops.common.entity.RfdResponse;
import com.uneecops.common.entity.RplyExtnNotice;

public class RfdNoticeMapper {

	public static Items mapRfdNotice(RfdNoticedto dto , RfdResponse rfdResponse) {
		if (ObjectUtils.isEmpty(dto)) {
			return null;
		}

//      set Item entity 
		Items item = new Items();
		BeanUtils.copyProperties(dto, item);

		ScreenDetailsdto screenDetailsdto = dto.getRfdNoticeData().getSdtls();
		RfdNoticeData rfdNoticeData = setCommonValues(new RfdNoticeData(), rfdResponse);
		if (screenDetailsdto != null) {
//		set base data
			BeanUtils.copyProperties(screenDetailsdto, rfdNoticeData);
//		set NoticeDataDocDetails docuPdtl
			rfdNoticeData.setDocupdtl(mapNoticeDataDocumentDetails(dto.getRfdNoticeData().getDocupdtl(), rfdNoticeData , rfdResponse));

//			set InadmissibleRsnSCN
			if (!CollectionUtils.isEmpty(screenDetailsdto.getInadmissibleRsnSCN())) {
				List<InadmissibleRsnSCN> inadmissibleRsnSCNs = screenDetailsdto.getInadmissibleRsnSCN().stream()
						.map(inad -> {
							InadmissibleRsnSCN inadmissibleRsnSCN = setCommonValues(new InadmissibleRsnSCN() , rfdResponse);
							BeanUtils.copyProperties(inad, inadmissibleRsnSCN);
							inadmissibleRsnSCN.setRfdNoticeData(rfdNoticeData);
							return inadmissibleRsnSCN;
						}).toList();
				rfdNoticeData.setInadmissibleRsnSCN(inadmissibleRsnSCNs);
			}
//			set RplyExtnNotice
			if (screenDetailsdto.getRplyextnnotice() != null) {
				RplyExtnNotice rplyextnnotice = setCommonValues(new RplyExtnNotice() , rfdResponse);
				BeanUtils.copyProperties(screenDetailsdto.getRplyextnnotice(), rplyextnnotice);
				BeanUtils.copyProperties(screenDetailsdto.getRplyextnnotice().getRplyextnreq(), rplyextnnotice);
				BeanUtils.copyProperties(screenDetailsdto.getRplyextnnotice().getPrsnlhrng(), rplyextnnotice);
				rplyextnnotice.setRfdNoticeData(rfdNoticeData);
				rfdNoticeData.setRplyextnnotice(rplyextnnotice);
			}
//			set NtcChngeBnkAcc
			if (screenDetailsdto.getNtcChngeBnkAcc() != null) {
				NtcChngeBnkAcc ntcChngeBnkAcc = setCommonValues(new NtcChngeBnkAcc() , rfdResponse);
				BeanUtils.copyProperties(screenDetailsdto.getNtcChngeBnkAcc(), ntcChngeBnkAcc);
				ntcChngeBnkAcc.setRfdNoticeData(rfdNoticeData);
				rfdNoticeData.setNtcChngeBnkAcc(ntcChngeBnkAcc);
			}
//			set NtcPersonalHearingDtls
			if (screenDetailsdto.getNtcPersonalHearingDtls() != null) {
				NtcPersonalHearingDtls ntcPersonalHearingDtls = setCommonValues(new NtcPersonalHearingDtls() , rfdResponse);
				BeanUtils.copyProperties(screenDetailsdto.getNtcPersonalHearingDtls(), ntcPersonalHearingDtls);
				ntcPersonalHearingDtls.setRfdNoticeData(rfdNoticeData);
				rfdNoticeData.setNtcPersonalHearingDtls(ntcPersonalHearingDtls);
			}
			
		}
		
		if (dto.getRfdNoticeData().getNtcSuppDoc() != null) {
			NoticeDataSuppDoc ntcSuppDoc = setCommonValues(new NoticeDataSuppDoc() , rfdResponse);
			BeanUtils.copyProperties(dto.getRfdNoticeData().getNtcSuppDoc(), ntcSuppDoc);
			ntcSuppDoc.setRfdNoticeData(rfdNoticeData);
			rfdNoticeData.setNtcSuppDoc(ntcSuppDoc);
		}
		if (dto.getRfdNoticeData().getTaxOfficerdetails() != null) {
			NoticeDataTaxOfficerDet noticeDataTaxOfficerDet = setCommonValues(new NoticeDataTaxOfficerDet() , rfdResponse);
			BeanUtils.copyProperties(dto.getRfdNoticeData().getTaxOfficerdetails(), noticeDataTaxOfficerDet);
			noticeDataTaxOfficerDet.setRfdNoticeData(rfdNoticeData);
			rfdNoticeData.setTaxOfficerdetails(noticeDataTaxOfficerDet);
		}
		item.setRfdNoticeData(rfdNoticeData);
		item.setRfdResponse(rfdResponse);
		item.setCrn(rfdResponse.getCrn());
		item.setGstin(rfdResponse.getGstin());
		rfdNoticeData.setItem(item);
		return item;

	}

	public static List<Items> mapRfdNoticeList(ItemDto itemDto , RfdResponse rfdResponse) {

		return itemDto.getRfdNotice().stream().map(dto -> mapRfdNotice(dto , rfdResponse)).collect(Collectors.toList());
	}
	
	private static List<NoticeDataDocumentDetails> mapNoticeDataDocumentDetails(
			List<NoticeDataDocumentDetailsDto> dtoList, RfdNoticeData noticeData , RfdResponse rfdResponse) {
		if (CollectionUtils.isEmpty(dtoList))
			return Collections.emptyList();
		return dtoList.stream().map(dto -> {
			NoticeDataDocumentDetails docDetails = setCommonValues(new NoticeDataDocumentDetails() , rfdResponse);
			BeanUtils.copyProperties(dto, docDetails);
			docDetails.setRfdNoticeData(noticeData);
			return docDetails;
		}).collect(Collectors.toList());
		
	}
	
	private static <T extends CommonEntityForAll> T setCommonValues(T entity, RfdResponse rfdResponse) {
	    entity.setGstin(rfdResponse.getGstin());
	    entity.setCrn(rfdResponse.getCrn());
	    return entity;
	}
}
