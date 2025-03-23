package com.uneecops.common.entity;

import java.math.BigDecimal;

import com.uneecops.common.enums.SanctionAmount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gst_rfd_sanc_amntdet")
@SequenceGenerator(name = "sanc_amnt_det_seq", sequenceName = "SANCTION_AMNT_DET_SEQ", allocationSize = 1)
public class SanctionAmntDetails extends CommonEntityForAll{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sanc_amnt_det_seq")
	@Column(name = "id")
	private Long id;

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

	@Column(name = "sanc_amnt_type")
	@Enumerated(EnumType.STRING)
	private SanctionAmount sancAmntType;

	@OneToOne
	@JoinColumn(name = "sancOrdDet_id", nullable = false)
	private SanctionOrderDet sanctionOrderDet;

}
