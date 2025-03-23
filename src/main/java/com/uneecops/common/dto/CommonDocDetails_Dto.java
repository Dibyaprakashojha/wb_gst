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
public class CommonDocDetails_Dto {

	@JsonProperty("ct")
	private String contentType;
	
	@JsonProperty("ty")
	private String typeCode;
	
	@JsonProperty("docttl")
	private String docFileName;
	
	@JsonProperty("id")
	private String docId;
	
	@JsonProperty("hash")
	private String hashCode;
}
