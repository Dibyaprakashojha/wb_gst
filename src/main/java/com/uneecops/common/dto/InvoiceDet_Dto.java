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
public class InvoiceDet_Dto {

	@JsonProperty("sgst")
	private BigDecimal sgstAmount;
	
	@JsonProperty("cgst")
	private BigDecimal cgstAmount;
	
	@JsonProperty("igst")
	private BigDecimal igstAmount;
	
	@JsonProperty("cess")
	private BigDecimal cessAmount;
	
	@JsonProperty("invoiceValue")
	private BigDecimal InvoiceAmount;
}
