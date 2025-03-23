package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonAmountDetForAllDto {

	@JsonProperty("clmamt")
	private ClaimedAmt_Dto claimedAmt;
	
	@JsonProperty("provamt")
	private ProvisionalAmt_Dto provamt;
	
	@JsonProperty("inadmamt")
	private Inadmissableamt_Dto inadmissableamt;
	
	@JsonProperty("grsamt")
	private Grossamt_Dto grossamt;
	
	@JsonProperty("adjamt")
	private Adjustedamt_Dto adjustedamt;
	
	@JsonProperty("netamt")
	private Netamt_Dto netamt;
	
	@JsonProperty("rcvrdamt")
	private RecoveredAmt_Dto recoveredAmt;
	
	@JsonProperty("cwfamt")
	private CWFinitiatedamount_Dto cwfamt;
}
