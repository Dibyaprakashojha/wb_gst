package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoticeDataPersonalHiringdetDto {

	@JsonProperty("dateofhearing")
	private String dateOfHearing;
	
	@JsonProperty("timeofhearing")
	private String timeOfHearing;
	
	@JsonProperty("requesteddate")
	private String requestedDate;
	
	@JsonProperty("requestedtime")
	private String requestedTime;
}
