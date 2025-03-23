package com.uneecops.common.dto;

import java.math.BigDecimal;

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
public class CommonRefAmount_Dto {

	@JsonProperty("igst")
	private BigDecimal igst;
	
	@JsonProperty("cgst")
	private BigDecimal cgst;
	
	@JsonProperty("sgst")
	private BigDecimal sgst;
	
	@JsonProperty("cess")
	private BigDecimal cess;
}
