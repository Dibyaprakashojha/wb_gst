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
public class DemandAdjustedCess_Dto{

	@JsonProperty("demand_adjusted_igst")
	private DemandAdjCess_IgstDto demAdjCess_Igst;

	@JsonProperty("demand_adjusted_sgst")
	private DemandAdjCess_SgstDto demAdjCess_Sgst;

	@JsonProperty("demand_adjusted_cgst")
	private DemandAdjCess_CgstDto demAdjCess_Cgst;
	
	@JsonProperty("demand_adjusted_cess")
	private DemandAdjCess_CessDto demAdjCess_Cess;
}
