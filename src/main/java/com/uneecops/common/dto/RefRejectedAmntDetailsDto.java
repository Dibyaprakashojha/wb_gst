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
public class RefRejectedAmntDetailsDto {

	@JsonProperty("igst")
	private RejRefAmountIgstDto rejRefAmntIgst;
	
	@JsonProperty("sgst")
	private RejRefAmountSgstDto rejRefAmntSgst;
	
	@JsonProperty("cgst")
	private RejRefAmountCgstDto rejRefAmntCgst;
	
	@JsonProperty("cess")
	private RejRefAmountCessDDto rejRefAmntCess;
	
}
