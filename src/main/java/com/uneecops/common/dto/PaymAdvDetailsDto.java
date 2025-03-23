package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymAdvDetailsDto {

	@JsonProperty("igst")
	private PayAdvScreenSpecIgstDataDto payAdvScreenSpecIgstData;
	
	
	@JsonProperty("cgst")
	private PayAdvScreenSpecCgstDataDto payAdvScreenSpecCgstData;
	
	
	@JsonProperty("sgst")
	private PayAdvScreenSpecSgstDataDto payAdvScreenSpecSgstData;
	
	
	@JsonProperty("cess")
	private PayAdvScreenSpecCessDataDto payAdvScreenSpecCessData;
}
