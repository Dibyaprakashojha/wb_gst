package com.uneecops.common.dto;

import java.math.BigDecimal;
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
public class RfndApplicationDataDto {

	@JsonProperty("decdtls")
	private DeclarationdtlsDto declarationDetails;

	@JsonProperty("frmtxprd")
	private String fromTaxPeriod;

	@JsonProperty("totxprd")
	private String toTaxPeriod;
	
	@JsonProperty("rsnSpec")
	private String refundSpecification;

	@JsonProperty("refClaim")
	private ReferenceClaimDto referenceClaim;

	@JsonProperty("suppdocs")
	private List<RfdAppSuppDocumentDto> supportingDocuments;

	@JsonProperty("statementType")
	private String statementType;

	@JsonProperty("rfdrsn")
	private String refundReason;
	
	@JsonProperty("autoFiling")
	private String autoFilingFlag;

	@JsonProperty("statement")
	private StatementDto statement;

	@JsonProperty("bnkdtls")
	private List<BankDetailsDTO> bankDetails;

	@JsonProperty("totrfdamt")
	private BigDecimal totalRefundAmount;

	@JsonProperty("stmntsummary")
	private StatementSummaryDTO statementSummary;
	
	@JsonProperty("supplierInfo")
	private SupplierInformationDto supplierInfo;
	
	@JsonProperty("stmnt7edt")
	private List<ReturnDetailsDTO> ReturnDetails;
	
	@JsonProperty("annxdocs")
	private List<AnnexureDocumentDTO> annexureDocuments;
	
	@JsonProperty("statutoryorderdetails")
	private StatutoryOrderDetailsDTO  statutoryOrderDetails;
}
