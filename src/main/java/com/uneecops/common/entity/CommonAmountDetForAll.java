package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonAmountDetForAll {

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "clm_amt_id", referencedColumnName = "id")
//    private ClaimedAmt claimedAmt;
    
	@Column(name = "clmAmt_intrest")
	private BigDecimal claimedAmtIntrest;
	
	@Column(name = "clmAmt_others")
	private BigDecimal claimedAmtOthers;
	
	@Column(name = "clmAmt_fee")
	private BigDecimal claimedAmtFee;
	
	@Column(name = "clmAmt_penalty")
	private BigDecimal claimedAmtPenalty;
	
	@Column(name = "clmAmt_tax")
	private BigDecimal claimedAmtTax;
	
	@Column(name = "clmAmt_Total")
	private BigDecimal claimedAmtTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "prov_amt_id", referencedColumnName = "id")
//    private ProvisionalAmt provamt;
	
	@Column(name = "provamt_intrest")
	private BigDecimal provamtIntrest;
	
	@Column(name = "provamt_others")
	private BigDecimal provamtOthers;
	
	@Column(name = "provamt_fee")
	private BigDecimal provamtFee;
	
	@Column(name = "provamt_penalty")
	private BigDecimal provamtPenalty;
	
	@Column(name = "provamt_tax")
	private BigDecimal provamtTax;
	
	@Column(name = "provamt_Total")
	private BigDecimal provamtTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inad_amt_id", referencedColumnName = "id")
//    private InadmissibleAmt inadmissibleAmt;
	
	@Column(name = "indmisleAmt_intre")
	private BigDecimal indmisleAmtIntrest;
	
	@Column(name = "indmisleAmt_others")
	private BigDecimal indmisleAmtOthers;
	
	@Column(name = "indmisleAmt_fee")
	private BigDecimal indmisleAmtFee;
	
	@Column(name = "indmisleAmt_penalty")
	private BigDecimal indmisleAmtPenalty;
	
	@Column(name = "indmisleAmt_tax")
	private BigDecimal indmisleAmtTax;
	
	@Column(name = "indmisleAmt_Total")
	private BigDecimal indmisleAmtTot;
	

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "grs_amt_id", referencedColumnName = "id")
//    private GrossAmt grossamt;
	
	@Column(name = "grossamt_intrest")
	private BigDecimal grossamtIntrest;
	
	@Column(name = "grossamt_others")
	private BigDecimal grossamtOthers;
	
	@Column(name = "grossamt_fee")
	private BigDecimal grossamtFee;
	
	@Column(name = "grossamt_penalty")
	private BigDecimal grossamtPenalty;
	
	@Column(name = "grossamt_tax")
	private BigDecimal grossamtTax;
	
	@Column(name = "grossamt_Total")
	private BigDecimal grossamtTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_amt_id", referencedColumnName = "id")
//    private AdjustedAmt adjustedAmt;
	
	@Column(name = "adjstdAmt_intrest")
	private BigDecimal adjustedAmtIntrest;
	
	@Column(name = "adjstdAmt_others")
	private BigDecimal adjstdAmtOthers;
	
	@Column(name = "adjstdAmt_fee")
	private BigDecimal adjstdAmtFee;
	
	@Column(name = "adjstdAmt_penalty")
	private BigDecimal adjstdAmtPenalty;
	
	@Column(name = "adjstdAmt_tax")
	private BigDecimal adjstdAmtTax;
	
	@Column(name = "adjstdAmt_Total")
	private BigDecimal adjstdAmtTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "net_amt_id", referencedColumnName = "id")
//    private NetAmt netamt;
	
	@Column(name = "netamt_intrest")
	private BigDecimal netamtIntrest;
	
	@Column(name = "netamt_others")
	private BigDecimal netamtOthers;
	
	@Column(name = "netamt_fee")
	private BigDecimal netamtFee;
	
	@Column(name = "netamt_penalty")
	private BigDecimal netamtPenalty;
	
	@Column(name = "netamt_tax")
	private BigDecimal netamtTax;
	
	@Column(name = "netamt_Total")
	private BigDecimal netamtTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rcvrd_amt_id", referencedColumnName = "id")
//    private RecoveredAmt recoveredAmt;
	
	@Column(name = "recvred_intrest")
	private BigDecimal recvredIntrest;
	
	@Column(name = "recvred_others")
	private BigDecimal recvredOthers;
	
	@Column(name = "recvred_fee")
	private BigDecimal recvredFee;
	
	@Column(name = "recvred_penalty")
	private BigDecimal recvredPenalty;
	
	@Column(name = "recvred_tax")
	private BigDecimal recvredTax;
	
	@Column(name = "recvred_Total")
	private BigDecimal recvredTot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cwf_amt_id", referencedColumnName = "id")
//    private CwfInitiatedAmt cwfamt;
	
	@Column(name = "cwfamt_intrest")
	private BigDecimal cwfamtIntrest;
	
	@Column(name = "cwfamt_others")
	private BigDecimal cwfamtOthers;
	
	@Column(name = "cwfamt_fee")
	private BigDecimal cwfamtFee;
	
	@Column(name = "cwfamt_penalty")
	private BigDecimal cwfamtPenalty;
	
	@Column(name = "cwfamt_tax")
	private BigDecimal cwfamtTax;
	
	@Column(name = "cwfamt_Total")
	private BigDecimal cwfamtTot;
	
}

