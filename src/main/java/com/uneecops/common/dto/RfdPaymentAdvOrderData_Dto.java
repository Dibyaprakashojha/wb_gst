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
public class RfdPaymentAdvOrderData_Dto {

	@JsonProperty("sdtls")
	private ScrnSpecDetPaymAdvOrdData_Dto ScrnSpecDetCompAdmntOrdData;

	@JsonProperty("docupdtl")
	private List<CommonDocDetails_Dto> commonDocDetails; // List of Document Upload Details

	@JsonProperty("todtls")
	private CommonTaxOfficerDet_Dto commonTaxOfficerDet; // Tax Officer details
}
