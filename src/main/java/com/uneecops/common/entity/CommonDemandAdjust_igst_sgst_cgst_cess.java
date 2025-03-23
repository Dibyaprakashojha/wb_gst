package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
public class CommonDemandAdjust_igst_sgst_cgst_cess {
	
	@Column(name = "igst_intrest")
	private BigDecimal igstIntrest;
	
	@Column(name = "igst_others")
	private BigDecimal igstOthers;
	
	@Column(name = "igst_fee")
	private BigDecimal igstFee;
	
	@Column(name = "igst_penalty")
	private BigDecimal igstPenalty;
	
	@Column(name = "igst_tax")
	private BigDecimal igstTax;
	
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
	
	
	
	
}
