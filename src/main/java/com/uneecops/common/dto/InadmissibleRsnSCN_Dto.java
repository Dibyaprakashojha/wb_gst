package com.uneecops.common.dto;

import java.math.BigDecimal;

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
public class InadmissibleRsnSCN_Dto {

	@JsonProperty("rsn")
	private String reasonInadmissibleSCN;
	
	@JsonProperty("amt")
	private BigDecimal amountReasonInadmissible;

	@JsonProperty("chkStatus")
	private Boolean checkStatus;
	
	@JsonProperty("name")
	private String name;
}
