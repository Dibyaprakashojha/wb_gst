package com.uneecops.common.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class StatutoryOrderDetailsDTO {

	@JsonProperty("orderno")
	private String orderNum;

	@JsonProperty("demandid")
	private String demandid;

	@JsonProperty("orderissuingauth")
	private String OrderissuingAuth;

	@JsonProperty("paymentreferencenumbers")
	private List<PaymentReferenceDetail_Dto> PaymentReferenceDetail;

	@JsonProperty("orderdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date OrderDate;

	@JsonProperty("otherorder")
	private String OtherOrderNumb;

	@JsonProperty("typeoforder")
	private String typeOfOrder;
}
