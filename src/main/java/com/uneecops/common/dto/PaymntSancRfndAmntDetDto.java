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
public class PaymntSancRfndAmntDetDto {

	@JsonProperty("igst")
	private PaymntSancRfndAmnt_IGSTDto  paymentSancRfndAmntigst;
	
	@JsonProperty("cgst")
	private PaymntSancRfndAmnt_CGSTDto  paymentSancRfndAmntcgst;
	
	@JsonProperty("sgst")
	private PaymntSancRfndAmnt_SGSTDto  paymentSancRfndAmntsgst;
	
	@JsonProperty("cess")
	private PaymntSancRfndAmnt_CESSDto  paymentSancRfndAmntcess;
	
}
