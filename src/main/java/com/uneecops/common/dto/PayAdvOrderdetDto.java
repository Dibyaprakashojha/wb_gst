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
public class PayAdvOrderdetDto {

	@JsonProperty("ordertype")
	private String orderType;
	
	@JsonProperty("rfdordty")
	private String rfdOrderType;
	
	@JsonProperty("cwfflag")
	private Boolean cwfInitiatedIndicator;
	
	@JsonProperty("rfdsanproorderno")
	private String rfdProSanOrdNo;
	
	@JsonProperty("prepayadvno")
	private String prevPaymAdvNo;
	
	@JsonProperty("pmtamtdtl")
	private PaymAdvDetailsDto paymAdvDet;
	
	@JsonProperty("remarks")
	private String remarks;
	
	@JsonProperty("status")
	private String payAdvStatus;
	
	@JsonProperty("rejRsnList")
	private List<PayAdvRejReasonDto> payAdvRejReason;
	
	@JsonProperty("disbAmount")
	private BigDecimal disbursedAmnt;

}
