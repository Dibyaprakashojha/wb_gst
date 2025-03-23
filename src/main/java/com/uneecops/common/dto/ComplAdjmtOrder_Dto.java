package com.uneecops.common.dto;

import java.util.List;

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
public class ComplAdjmtOrder_Dto {

	@JsonProperty("ordertype")
	private String ordrType;
	
	@JsonProperty("inadmreasoncom")
	private List<String> reasonForSelection;
	
	@JsonProperty("comamtdtl")
	private  RefAmtDetOfComplAdjmtOrder  refAmtDetOfComplAdjmtOrder;
	
	@JsonProperty("remarks")
	private String remarks;
}
