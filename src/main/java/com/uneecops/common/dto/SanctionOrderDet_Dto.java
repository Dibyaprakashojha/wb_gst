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
public class SanctionOrderDet_Dto {

	@JsonProperty("ordertype")
	private String refundOrderType;
	
	@JsonProperty("adjusteddemandDetails")
	private List<AdjustedDemandDet_Dto> adjustedDemDet;

	@JsonProperty("inadmreason")
	private List<String> inadmreason;

	@JsonProperty("otherReason")
	private String otherReason;

	@JsonProperty("sancamtdtl")
	private RefAmtScreenData_Dto refAmtScreenData;

	@JsonProperty("cwfflag")
	private Boolean cwfflag;

	@JsonProperty("remarks")
	private String remarks;
	
	@JsonProperty("riskexpalrt")
	private String riskExpAlert;
	
	@JsonProperty("riskexpremarks")
	private String riskExpMarks;

}
