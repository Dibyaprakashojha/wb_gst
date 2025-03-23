package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementDto {

	@JsonProperty("adjto")
	private AdjustedTOdto adjustedturnover;
	
	@JsonProperty("invto")
	private InvertedTurnOverdto invertedDturnOver;

	@JsonProperty("zeroto")
	private ZeroratedTurnOverDto zeroratedturnover;

	@JsonProperty("netITCBal")
	private NetItcBalancedto netITCBal;

	@JsonProperty("taxpybinv")
	private InvertedRatedTax_Dto taxpybinv;

	@JsonProperty("netitc")
	private NetITCDetails_Dto netitc;

//	@JsonProperty("ttlItc")
//	private TtlItcDetails_Dto ttlitc;
}
