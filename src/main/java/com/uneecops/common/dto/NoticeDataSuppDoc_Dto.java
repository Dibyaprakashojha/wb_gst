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
public class NoticeDataSuppDoc_Dto {

	@JsonProperty("docttl")
	private String docTitle;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("ty")
	private String typeCode;
	
	@JsonProperty("ct")
	private String contentType;
	
	@JsonProperty("hash")
	private String hashCode;
}
