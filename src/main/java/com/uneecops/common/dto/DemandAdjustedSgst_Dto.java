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
public class DemandAdjustedSgst_Dto {

	@JsonProperty("demand_adjusted_igst")
	private DemandAdjSgst_IgstDto demAdjSgst_Igst;

	@JsonProperty("demand_adjusted_sgst")
	private DemandAdjSgst_SgstDto demAdjSgst_Sgst;

	@JsonProperty("demand_adjusted_cgst")
	private DemandAdjSgst_CgstDto demAdjSgst_Cgst;
	
	@JsonProperty("demand_adjusted_cess")
	private DemandAdjSgst_CessDto demAdjSgst_Cess;
}
