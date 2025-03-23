package com.uneecops.common.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfdNoticedto implements Serializable {

	@JsonProperty("itemName")
	private String itemName;
	
	@JsonProperty("refdt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date refDt;
	
	@JsonProperty("refId")
	private String refId;
	
	@JsonProperty("rfdNoticeData")
	private RfdNoticeDatadto rfdNoticeData;
	
	@JsonProperty("hash")
	private String hash;
}
