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
public class DemandAdjustedCgst_Dto{

	@JsonProperty("demand_adjusted_igst")
	private DemandAdjCgst_IgstDto demAdjCgst_Igst;

	@JsonProperty("demand_adjusted_sgst")
	private DemandAdjCgst_SgstDto demAdjCgst_Sgst;

	@JsonProperty("demand_adjusted_cgst")
	private DemandAdjCgst_CgstDto demAdjCgst_Cgst;
	
	@JsonProperty("demand_adjusted_cess")
	private DemandAdjCgst_CessDto demAdjCgst_Cess;
}
