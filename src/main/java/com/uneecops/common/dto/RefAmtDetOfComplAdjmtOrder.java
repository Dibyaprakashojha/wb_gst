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
public class RefAmtDetOfComplAdjmtOrder {

	@JsonProperty("clmamt")
	private RefClaimAmnt refClaimAmnt;
	
	@JsonProperty("netprosancamt")
	private NetRefAmount netRefAmnt;
	
	@JsonProperty("inadmamt")
	private RefAmntinadmamtRej refAmntinadmamtRej;
	
	@JsonProperty("admamt")
	private RefAmntAdmissible refAmntAdmissible;
	
	@JsonProperty("adjamt")
	private RefAmntAdjusted  refAmntAdjusted;
	
	@JsonProperty("balncamt")
	private RefBalAmnt balncamt;
}
