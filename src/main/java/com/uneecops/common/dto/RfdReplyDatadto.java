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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfdReplyDatadto {

	@JsonProperty("replydt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date replyDate;

	@JsonProperty("ntcno")
	private String scnId;

	@JsonProperty("ntcdt")
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy")
	private Date scnDate;

	@JsonProperty("maindocs")
	private List<RepmainDocdto> maindocs;

	@JsonProperty("suppdocs")
	private List<RfdRepSuppDocDto> suppdocs;
	
	@JsonProperty("decdtls")
	private ReplDataDeclarationDet_Dto declarationDetails;
	
	@JsonProperty("tyreply")
	private String typeOfRep;
	
	@JsonProperty("prsnlhrng")
	private RfdRepDataPersonalHiringdet_Dto prsnlhrng;
	
	@JsonProperty("rplyextnreq")
	private RedReplDataRplyextnreq_Dto rplyextnreq;
	
	@JsonProperty("undertakingAmtDtl")
	private UndertakingAmtDetails_Dto undertakingAmtDtl;
	
	@JsonProperty("rplyToChngeBankAcc")
	private Replychangebankaccount_dto repchangebankaccount;
	
	@JsonProperty("SCNReply")
	private ScnReply_Dto scnReply;
	
	@JsonProperty("undertakingNil")
	private String undertakingNil;

}
