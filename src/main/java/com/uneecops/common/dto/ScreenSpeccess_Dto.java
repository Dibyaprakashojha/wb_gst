package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreenSpeccess_Dto {
	
	@JsonProperty("ldgrrecreditamt")
	private LedgerRecreditamountcess_Dto ledgerRecreditamtcess;
	
	@JsonProperty("inadmamt")
	private InadmissibleAmountcess_Dto  InadmissibleAtcess;

}
