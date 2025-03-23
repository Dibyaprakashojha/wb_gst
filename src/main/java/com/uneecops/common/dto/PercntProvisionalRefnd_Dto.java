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
public class PercntProvisionalRefnd_Dto {

	@JsonProperty("igst")
	private Integer igst;
	
	@JsonProperty("cgst")
	private Integer cgst;
	
	@JsonProperty("sgst")
	private Integer sgst;
	
	@JsonProperty("cess")
	private Integer cess;
}
