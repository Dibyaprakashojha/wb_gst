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
public class Rfd_RejAmntDto {

	@JsonProperty("ordertype")
	private String orderType;

	@JsonProperty("rfdsanproorderno")
	private String rfdProSanOrderNo;

	@JsonProperty("rejamtdtl")
	private RefRejectedAmntDetailsDto refRejectedAmntDetails;

	@JsonProperty("remarks")
	private String remarks;

	@JsonProperty("declaration")
	private List<DeclarationDocDto> declarationDoc;

}
