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
public class DemandAdjustedIgst_Dto{

	@JsonProperty("demand_adjusted_igst")
	private DemandAdjIgst_IgstDto demAdjIgst_Igst;

	@JsonProperty("demand_adjusted_sgst")
	private DemandAdjIgst_SgstDto demAdjIgst_Sgst;

	@JsonProperty("demand_adjusted_cgst")
	private DemandAdjIgst_CgstDto demAdjIgst_Cgst;
	
	@JsonProperty("demand_adjusted_cess")
	private DemandAdjIgst_CessDto demAdjIgst_Cess;
}
