package com.uneecops.common.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GST_RFND_APPLICATION_DATA")
@SequenceGenerator(name = "rfnd_app_data_seq", sequenceName = "RFND_APP_DATA_SEQ", allocationSize = 1)
public class RfndApplicationData extends CommonEntityForAll{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfnd_app_data_seq")
	@Column(name = "app_data_id")
	private Long appDataId;	
	
	@Column(name = "from_tax_period", length = 6)
	private String fromTaxPeriod;

	@Column(name = "to_tax_period", length = 6)
	private String toTaxPeriod;

	@Column(name = "rfndSpecification")
	private String RefundSpecification;

	@Column(name = "statement_type", length = 10)
	private String statementType;

	@Column(name = "refund_reason", length = 50)
	private String refundReason;

	@Column(name = "total_refund_amount", precision = 15, scale = 2)
	private BigDecimal totalRefundAmount;

	// Relationships
	@OneToOne(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true)
	private Declarationdtls declarationDetails;

	@OneToMany(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SuppDocumentDetails> supportingDocuments;
		
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
	
//	@Column(name = "gstin", length = 15, nullable = false)
//	private String gstin;
	
    @OneToMany(mappedBy = "rfndApplicationData" , cascade= CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    private List<InvoiceDetails> invoiceDtls;
	
    @Column(name = "total_invoice_amount")
    private BigDecimal totalInvoiceAmount;

    @Column(name = "invoice_count")
    private String invoiceCount;

	@OneToMany(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<BankDetails> bankDetails;

	@OneToOne(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true)
	private Statement statement;

	@OneToOne(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true)
	private StatutoryOrderDetails statutoryOrderDetails;

	@OneToMany(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ReturnDetails> returnDetails;

	@OneToMany(mappedBy = "rfndApplicationData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<AnnexureDocumentDetails> annexureDocuments;

	@Column(name = "auto_filing_flag")
	private String autoFilingFlag;

	@OneToOne
	@JoinColumn(name = "item_id" , nullable = false)
	private Items items;
}
