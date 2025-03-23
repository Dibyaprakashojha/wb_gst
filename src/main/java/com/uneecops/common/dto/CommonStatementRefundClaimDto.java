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
public class CommonStatementRefundClaimDto {

	@JsonProperty("intr")
	private BigDecimal intrest;
	
	@JsonProperty("oth")
	private BigDecimal others;
	
	@JsonProperty("fee")
	private BigDecimal fee;
	
	@JsonProperty("pen")
	private BigDecimal penalty;
	
	@JsonProperty("tax")
	private BigDecimal tax;
	
	@JsonProperty("tot")
	private BigDecimal tot;
}
