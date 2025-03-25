package com.uneecops.common.entity;

import java.math.BigDecimal;

import com.uneecops.common.enums.UnderTakingAmount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GST_RFND_REP_UNDERTKNGAMNT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rfd_reply_undrtkngamnt_seq", sequenceName = "RFD_REPLY_UNDERTKNGAMNT_SEQ", allocationSize = 1)
public class UndertakingAmtDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_reply_undrtkngamnt_seq")
    @Column(name = "id")
    private Long id; // Primary Key
    
    @Column(name = "undertaking_amnt")
    @Enumerated(EnumType.STRING)
    private UnderTakingAmount underTakingAmount;
    
	@Column(name = "igst_intrest")
	private BigDecimal igstIntrest;
	
	@Column(name = "igst_others")
	private BigDecimal igstOthers;
	
	@Column(name = "igst_fee")
	private BigDecimal igstFee;
	
	@Column(name = "igst_penalty")
	private BigDecimal igstPenalty;
	
	@Column(name = "igst_tax")
	private BigDecimal igsTtax;
	
	@Column(name = "igst_Total")
	private BigDecimal igstTot;
	
	@Column(name = "sgst_intrest")
	private BigDecimal sgstIntrest;
	
	@Column(name = "sgst_others")
	private BigDecimal sgstOthers;
	
	@Column(name = "sgst_fee")
	private BigDecimal sgstFee;
	
	@Column(name = "sgst_penalty")
	private BigDecimal sgstPenalty;
	
	@Column(name = "sgst_tax")
	private BigDecimal sgstTax;
	
	@Column(name = "sgst_Total")
	private BigDecimal sgstTot;
	
	@Column(name = "cgst_intrest")
	private BigDecimal cgstIntrest;
	
	@Column(name = "cgst_others")
	private BigDecimal cgstOthers;
	
	@Column(name = "cgst_fee")
	private BigDecimal cgstFee;
	
	@Column(name = "cgst_penalty")
	private BigDecimal cgstPenalty;
	
	@Column(name = "cgst_tax")
	private BigDecimal cgstTax;
	
	@Column(name = "cgst_Total")
	private BigDecimal cgstTot;
	
	@Column(name = "cess_intrest")
	private BigDecimal cessIntrest;
	
	@Column(name = "cess_others")
	private BigDecimal cessOthers;
	
	@Column(name = "cess_fee")
	private BigDecimal cessFee;
	
	@Column(name = "cess_penalty")
	private BigDecimal cessPenalty;
	
	@Column(name = "cess_tax")
	private BigDecimal cessTax;
	
	@Column(name = "cess_Total")
	private BigDecimal cessTot;
    
    @ManyToOne
    @JoinColumn(name = "rfd_reply_data_id" , nullable = false)
    private RfdReplyData rfdReplyData;
}
