package com.uneecops.common.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {

	@JsonProperty("itemName")
	private String itemName;

	@JsonProperty("refId")
	private String refId;

	@JsonProperty("refdt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date refDt;

	@JsonProperty("hash")
	private String hash;
	
	@JsonProperty("rfdAppData")
	private RfndApplicationDataDto rfdAppData;

	@JsonProperty("rfdNotice")
	private List<RfdNoticedto> rfdNotice;

	@JsonProperty("rfdReply")
	private List<RfdReplydto> rfdReply;

	@JsonProperty("rfdProOrderData")
	private RfdProvisionalOrderData_Dto rfdProvisionalOrderData;

	@JsonProperty("rfdSanOrderData")
	private RfdSanctionOrderData_Dto rfdSanOrderData;

	@JsonProperty("rfdComOrderData")
	private RfdCompleteAdmntOrderData_Dto rfdCompleteAdmntOrderData;

	@JsonProperty("rfdWHeldOrderData")
	private RfdWithHeldOrderData_Dto rfdWithHeldOrderData;

	@JsonProperty("rfdPayAdvice")
	private List<RfdPaymentAdv_Dto> rfdPaymentAdv;
	
	@JsonProperty("rfdPmt03")
	private List<RfdPMT_03_Dto> rfdPMT03;

	@JsonProperty("rfdWth")
	private RfdWithDrawData_Dto rfdWithDrawData;

	@JsonProperty("rfdReleaseOrderData")
	private RfdReleaseOrderData_Dto rfdReleaseOrdData;

	@JsonProperty("pmtSancAmtOrderData")
	private RfdPaymntSancOrdData_Dto rfdPaymntSancOrdData;


}
