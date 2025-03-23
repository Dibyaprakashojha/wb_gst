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
public class CommonSupportDocDetDTO {

	@JsonProperty("docName")
	private String docName;
	
	@JsonProperty("id")
	private String docid;
	
	@JsonProperty("ty")
	private String docTypeCode;
	
	@JsonProperty("docttl")
	private String docTtl;
	
	@JsonProperty("ct")
	private String docContentType;
	
	@JsonProperty("hash")
	private String hash;
}
