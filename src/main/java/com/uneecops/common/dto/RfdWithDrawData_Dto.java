package com.uneecops.common.dto;

import java.math.BigDecimal;
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
public class RfdWithDrawData_Dto {

	@JsonProperty("refId")
	private String withdrawRefNumb;
	
	@JsonProperty("maindocs")
	private WithDraw_MainDoc  withDrawMainDoc;
	
	@JsonProperty("suppdocs")
	private List<WithDraw_SuppDoc> withDrawSupDoc;
	
	@JsonProperty("arn")
	private String arn;
	
	@JsonProperty("gstin")
	private String gstin;
	
	@JsonProperty("rfdSubDt")
	private String refSubmittedDate;
	
	@JsonProperty("refundRsn")
	private String groundOfRfnd;
	
	@JsonProperty("ttlRfdAmt")
	private BigDecimal rfndClaimAmount;
	
	@JsonProperty("toRetPrd")
	private String toPeriod;
	
	@JsonProperty("fromRetPrd")
	private String fromPeriod;
	
	@JsonProperty("status")
	private String applicationStatus;
	
	@JsonProperty("legalName")
	private String legalName;
	
	@JsonProperty("withdrawRsn")
	private String reasonOfWithDraw;
}
