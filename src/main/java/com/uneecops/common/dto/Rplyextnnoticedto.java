package com.uneecops.common.dto;

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
public class Rplyextnnoticedto {
	
	@JsonProperty("noticeType")
	private String noticeType;
	
	@JsonProperty("rplyextnreq")
	private NoticeDataRplyextnreqdto rplyextnreq;
	
	@JsonProperty("action")
	private String action;
	
	@JsonProperty("ntcRefid")
	private String ntcRefid;
	
	@JsonProperty("ntcDate")
	private String ntcDate;
	
	@JsonProperty("replyId")
	private String replyId;
	
	@JsonProperty("replydt")
	private String replydt;
	
	@JsonProperty("prsnlhrng")
	private NoticeDataPersonalHiringdetDto prsnlhrng;
}
