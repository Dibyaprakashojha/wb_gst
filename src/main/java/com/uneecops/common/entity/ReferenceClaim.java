package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "GST_RFND_APPDATA_REFECLAIM")
@SequenceGenerator(name = "ref_claim_seq", sequenceName = "REF_CLAIM_SEQ", allocationSize = 1)
public class ReferenceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_claim_seq")
    @Column(name = "claim_id")
    private Long claimId;
    
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "igstRefClaimDet_id")
//    private IgstRefClaimDet igstRefClaimDet;
    
	@Column(name = "igst_intrest")
	private BigDecimal igstintrest;
	
	@Column(name = "igst_others")
	private BigDecimal igstothers;
	
	@Column(name = "igst_fee")
	private BigDecimal igstfee;
	
	@Column(name = "igst_penalty")
	private BigDecimal igstpenalty;
	
	@Column(name = "igst_tax")
	private BigDecimal igsttax;
	
	@Column(name = "igst_Total")
	private BigDecimal igsttot;
    
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "sgstRefClaimDet_id")
//    private SgstRefClaimDet sgstRefClaimDet;
    
	@Column(name = "sgst_intrest")
	private BigDecimal sgstintrest;
	
	@Column(name = "sgst_others")
	private BigDecimal sgstothers;
	
	@Column(name = "sgst_fee")
	private BigDecimal sgstfee;
	
	@Column(name = "sgst_penalty")
	private BigDecimal sgstpenalty;
	
	@Column(name = "sgst_tax")
	private BigDecimal sgsttax;
	
	@Column(name = "sgst_Total")
	private BigDecimal sgsttot;
    
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "cessRefClaimDet_id")
//    private CessRefClaimDet cessRefClaimDet;
    
	@Column(name = "cess_intrest")
	private BigDecimal cessintrest;
	
	@Column(name = "cess_others")
	private BigDecimal cessothers;
	
	@Column(name = "cess_fee")
	private BigDecimal cessfee;
	
	@Column(name = "cess_penalty")
	private BigDecimal cesspenalty;
	
	@Column(name = "cess_tax")
	private BigDecimal cesstax;
	
	@Column(name = "cess_Total")
	private BigDecimal cesstot;
    
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "cgstRefClaimDet_id")
//    private CgstRefClaimDet cgstRefClaimDet;
    
	@Column(name = "cgst_intrest")
	private BigDecimal cgstintrest;
	
	@Column(name = "cgst_others")
	private BigDecimal cgstothers;
	
	@Column(name = "cgst_fee")
	private BigDecimal cgstfee;
	
	@Column(name = "cgst_penalty")
	private BigDecimal cgstpenalty;
	
	@Column(name = "cgst_tax")
	private BigDecimal cgsttax;
	
	@Column(name = "cgst_Total")
	private BigDecimal cgsttot;
}
