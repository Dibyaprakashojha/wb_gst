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
public class ScnSpecDetProOrderData_Dto {
	
	@JsonProperty("proordervo")
	private ProvisionalOrderVo_Dto  provisionalOrderVo;
	
	@JsonProperty("remarks")
	private String remarks;
	


}
