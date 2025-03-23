package com.uneecops.common.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RfdPMT_03_Dto {

	@JsonProperty("itemName")
	private String itemName;
	
	@JsonProperty("rfdRejAmtOrderData")
	private RfdRejectedAmntData_Dto rfdRejectedAmntData;
	
	@JsonProperty("refdt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date refDt;
	
	@JsonProperty("refId")
	private String refId;
	
	@JsonProperty("hash")
	private String hash;
}
