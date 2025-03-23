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
public class CommonNetItcDetDto {

	@JsonProperty("igrfclm")
	private NetItcIGST_Dto  igrfclm;
	
	@JsonProperty("sgrfclm")
	private NetItcSGST_Dto sgrfclm;
	
	@JsonProperty("cgrfclm")
	private NetItcCGST_Dto  cgrfclm;
	
	@JsonProperty("csrfclm")
	private NetItcCESS_Dto  csrfclm;
	
}
