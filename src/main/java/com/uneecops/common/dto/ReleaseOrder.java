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
public class ReleaseOrder {

	@JsonProperty("ordertype")
	private String orderType;
	
	@JsonProperty("rfdwithheldorderno")
	private String withHeldRefId;
	
	@JsonProperty("releaseamtdtl")
	private ReleaseOrderDetails  releaseOrderDet;
	
	@JsonProperty("amtreleasedby")
	private AmntReleasedBy amntReleasedBy;
}
