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
public class RefAmtScreenData_Dto {

	@JsonProperty("igst")
	private SanOrder_ScrnSpecIGSTData_Dto scrnSpecIGSTData;
	
	@JsonProperty("cgst")
	private SanOrder_ScrnSpecCGSTData_Dto scrnSpecCGSTData;
	
	@JsonProperty("sgst")
	private SanOrder_ScrnSpecSGSTData_Dto scrnSpecSGSTData;
	
	@JsonProperty("cess")
	private SanOrder_ScrnSpecCESSData_Dto scrnSpecCESSData;
}
