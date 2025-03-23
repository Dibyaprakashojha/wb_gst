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
public class CommonPayAdvRefAmntAllDto {

	@JsonProperty("netsancamt")
	private PayAdvNetRefAmntSacDto payAdvNetRefAmntSac;
	
	@JsonProperty("intdlyamt")
	private PayAdvDelayedRefIntDto payAdvDelayedRefInt;
	
}
