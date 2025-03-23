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
public class WithHeldOrderDet {

	@JsonProperty("sancamt")
	private AmntRefSanct refAmntSanc;
	
	@JsonProperty("wthldamt")
	private AmntRefWithheld amntRefWithHeld;
	
	@JsonProperty("rfdalwd")
	private AmntRefAllowed amntRefAllowed;
	
	@JsonProperty("clmamtrfd01")
	private AmntClmByTaxPayer amntClmByTaxPayer;
	
	@JsonProperty("rfd06inadmissbleamt")
	private InadmissibleamountRFD06  inadmissibleAmmountRFD06;
	
	@JsonProperty("adjstamtrfd06")
	private AdjAmntRFD06 adjAmntRFD06;
	
	@JsonProperty("rfd04sancamt")
	private AmntSancRFD04 amntSanctRFD04;
	
	
}
