package com.uneecops.common.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfdNoticeDatadto {

	@JsonProperty("docupdtl")
	private List<NoticeDataDocumentDetailsDto> docupdtl;

	@JsonProperty("sdtls")
	private ScreenDetailsdto sdtls;

	@JsonProperty("suppdocs")
	private NoticeDataSuppDoc_Dto ntcSuppDoc;

	@JsonProperty("todtls")
	private NoticeDataTaxOfficerDetdto taxOfficerdetails;

}
