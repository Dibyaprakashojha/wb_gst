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
public class ScreenDetailsdto {

	@JsonProperty("tynotice")
	private String typeOfNotice;

	@JsonProperty("scninadmrsnList")
	private List<InadmissibleRsnSCN_Dto> InadmissibleRsnSCN;

	@JsonProperty("remarks")
	private String remarks;

	@JsonProperty("defrsnnoticeList")
	private List<String> reasonListDeficiencMemo;

	@JsonProperty("duedate")
	private String duedate;

	@JsonProperty("phdt")
	private String phdt;

	@JsonProperty("rplyextnnotice")
	private Rplyextnnoticedto rplyextnnotice;

	@JsonProperty("ntcChngeBnkAcc")
	private NtcChngeBnkAccdto ntcChngeBnkAcc;

	@JsonProperty("prsnlhrng")
	private NtcPersonalHearingDtlsDto ntcPersonalHearingDtls;

}
