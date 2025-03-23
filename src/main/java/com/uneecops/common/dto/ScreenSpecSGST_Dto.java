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
public class ScreenSpecSGST_Dto {

	@JsonProperty("ldgrrecreditamt")
	private LedgerRecreditamtSGST_Dto ldgrrecreditamt;
	
	@JsonProperty("inadmamt")
	private InadmissibleAmounSGST_Dto inadmamt;
}
