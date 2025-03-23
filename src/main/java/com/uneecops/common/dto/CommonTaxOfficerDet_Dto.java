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
public class CommonTaxOfficerDet_Dto {

	@JsonProperty("toid")
	private String taxOfficerId;
	
	@JsonProperty("dt")
	private String signatureDate;
	
	@JsonProperty("dg")
	private String taxOfficerDesignation;
	
	@JsonProperty("signty")
	private String taxOfficerSignType;
	
	@JsonProperty("pl")
	private String taxOfficerPlace;
	
	@JsonProperty("pn")
	private String taxOfficerPanNumber;
	
	@JsonProperty("nm")
	private String taxOfficerName;
}
