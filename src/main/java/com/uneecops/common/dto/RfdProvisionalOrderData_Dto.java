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
public class RfdProvisionalOrderData_Dto {

	@JsonProperty("sdtls")
	private ScnSpecDetProOrderData_Dto scnSpecDetProOrderData;

	@JsonProperty("docupdtl")
	private List<ProOrderDataDocDet_Dto> proOrderDataDocDet;

	@JsonProperty("todtls")
	private ProOrderDataTaxOfcDet_Dto proOrderDataTaxOfcDet;
}
