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
public class ScreenSpecIGST_Dto {
	
	@JsonProperty("ldgrrecreditamt")
	private LedgerRecreditamtIGST_Dto ldgrrecreditamt;
	
	@JsonProperty("inadmamt")
	private InadmissibleAmounIGST_Dto inadmamt;

}
