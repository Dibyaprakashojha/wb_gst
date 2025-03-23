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
public class ProvisionalOrderDet_Dto {

	@JsonProperty("clmamt")
	private RefundClaimAmt_Dto refundClaimAmt;
	
	@JsonProperty("provper")
	private PercntProvisionalRefnd_Dto  percntProvisionalRefnd;
	
	@JsonProperty("provamt")
	private ProvisionalRefAmt_Dto provisionalRefAmt;
	
	@JsonProperty("balncamt")
	private BalanceAmt_Dto balanceAmt;
	
	@JsonProperty("sancamt")
	private SanctionedRefAmt_Dto sanctionedRefAmt;
}
