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
public class AdjustedDemandDet_Dto {

	@JsonProperty("demandid")
	private String adjustedDemId;
	
	@JsonProperty("orderid")
	private String adjustedDemOrderId;
	
	@JsonProperty("order_gross_igst")
	private DemandAdjustedIgst_Dto demandAdjustedIgst;
	
	@JsonProperty("order_gross_sgst")
	private DemandAdjustedSgst_Dto demandAdjustedSgst;
	
	@JsonProperty("order_gross_cgst")
	private DemandAdjustedCgst_Dto demandAdjustedCgst;
	
	@JsonProperty("order_gross_cess")
	private DemandAdjustedCess_Dto demandAdjustedCess;
	
}
