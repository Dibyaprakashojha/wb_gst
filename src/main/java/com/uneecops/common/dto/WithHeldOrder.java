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
public class WithHeldOrder {

	@JsonProperty("ordertype")
	private String orderType;
	
	@JsonProperty("rfdsanproorderno")
	private String refProsanOrderNo;
	
	@JsonProperty("withheldOrdRsnList")
	private List<String> reasonForSelection;
	
	@JsonProperty("withholdOthRsnText")
	private String otherReason;
	
	@JsonProperty("wheldamtdtl")
	private WithHeldOrderDet withHeldOrederDet;
	
	@JsonProperty("amtwthldby")
	private AmountWithHeld amountWithHeld;
	
	@JsonProperty("descofrsn")
	private String reasonDescription;
	
	@JsonProperty("rcrdofprsnlhrng")
	private String personalHearing;
	
	@JsonProperty("remarks")
	private String remarks;
}
