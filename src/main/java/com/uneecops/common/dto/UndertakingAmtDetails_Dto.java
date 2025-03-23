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
public class UndertakingAmtDetails_Dto {
	
	@JsonProperty("igst")
	private ScreenSpecIGST_Dto screenspecIGSTdata;
	
	@JsonProperty("cgst")
	private ScreenspecificCGST_Dto screenspecificCGSTdata;
	
	@JsonProperty("sgst")
	private ScreenSpecSGST_Dto screenSpecSGST;
	
	@JsonProperty("cess")
	private ScreenSpeccess_Dto  screenSpeccess;
}
