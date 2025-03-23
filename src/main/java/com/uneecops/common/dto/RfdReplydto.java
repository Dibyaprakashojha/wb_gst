package com.uneecops.common.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfdReplydto {
	
	@JsonProperty("itemName")
	private String itemName;
	
	@JsonProperty("rfdReplyData")
	private RfdReplyDatadto rfdReplyData;
	
	@JsonProperty("refId")
	private String refId;
	
	@JsonProperty("refdt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date refDt;
	
	@JsonProperty("hash")
	private String hash;

}
