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
public class CommonUnderTakingAmntDto {

	@JsonProperty("ldgrrecreditamt")
	private LedgerRecreditamt_Dto ldgrrecreditamt;
	
	@JsonProperty("inadmamt")
	private InadmissibleAmount_Dto inadmamt;
}
