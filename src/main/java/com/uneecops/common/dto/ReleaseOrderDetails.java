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
public class ReleaseOrderDetails {

	@JsonProperty("clmamtrfd01")
	private ReleaseOrdAmntCaimTaxPayer  releaseOrdAmntClaimTaxPayer;
	
	@JsonProperty("rfd04sancamt")
	private ReleaseOrdeAmntSancRFD04 releaseOrdeAmntSancRFD04;
	
	@JsonProperty("rfd06inadmissbleamt")
	private ReleaseOrdInadmissibleAmntRFD06 releaseOrdInadmissibleAmntRFD06;
	
	@JsonProperty("adjstamtrfd06")
	private ReleaseOrdAdjAmnyRFD06 releaseOrdAdjAmnyRFD06;
	
	@JsonProperty("wthldamt")
	private ReleaseOrdWithHeldRefAmnt ReleaseOrdWithHeldRefAmnt;
	
	@JsonProperty("releaseamt")
	private ReleaseOrdTotAmntReleased  releaseOrdTotAmntReleased;
	
	@JsonProperty("paidamt")
	private ReleaseOrdAmntBePaid releaseOrdAmntBePaid;
	
	
}
