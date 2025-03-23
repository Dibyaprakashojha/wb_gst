package com.uneecops.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "gst_rfd_reje_amnt_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "rfd_rej_amnt_data_seq", sequenceName = "RFD_REJ_AMNT_DATA_SEQ", allocationSize = 1)
public class RfdRejectedAmntData extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rej_amnt_data_seq")
    @Column(name = "id")
    private Long id; // Primary Key

//    // One-to-One Relationship with ScrnSpecDetRejectedAmntData
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "scrn_spec_det_id", referencedColumnName = "id")
//    private ScrnSpecDetRejectedAmntData scrnSpecDetCompAdmntOrdData;
    
    @Column(name = "rejamt_order_type")
    private String rejAmtorderType;

    @Column(name = "rej_amtrfd_pro_no")
    private String rfdProSanOrderNo;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reje_amnt_det_id", referencedColumnName = "id")
//    private RefRejectedAmntDetails refRejectedAmntDetails;
    

    // One-to-One with RejRefAmountIgst
//    @OneToOne(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
//    private RejRefAmountIgst rejRefAmntIgst;
    
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

    // One-to-One with RejRefAmountSgst
//    @OneToOne(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
//    private RejRefAmountSgst rejRefAmntSgst;
    
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
    

    // One-to-One with RejRefAmountCgst
//    @OneToOne(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
//    private RejRefAmountCgst rejRefAmntCgst;
    
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

    // One-to-One with RejRefAmountCess
//    @OneToOne(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
//    private RejRefAmountCess rejRefAmntCess;
    
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

    @Column(name = "rejamt_remarks")
    private String remarks;

    @OneToMany(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RfdRejDeclnDoc> declarationDocs; // List of Declaration Documents

    // One-to-Many Relationship with CommonDocDetails
    @OneToMany(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RfdRejAmntDocDetails> rfdRejAmntDocDetails;

    // One-to-One Relationship with CommonTaxOfficerDet
    @OneToOne(mappedBy = "rfdRejectedAmntData", cascade = CascadeType.ALL, orphanRemoval = true)
    private RfdRejAmntToDet rfdRejAmntToDet;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rfd_pmt03_id", referencedColumnName = "id")
//    private RfdPMT03 rfdPMT03;
    
	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Items item; // Now directly linked to Item
}
