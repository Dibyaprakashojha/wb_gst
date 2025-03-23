package com.uneecops.common.dto;

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
public class ScreenspecificCGST_Dto {
	
	@JsonProperty("ldgrrecreditamt")
	private LedgerRecreditamountCGST_Dto ledgerRecreditamtCGST;
	
	@JsonProperty("inadmamt")
	private InadmissibleAmountCGST_Dto  InadmissibleAtCGST;

}
