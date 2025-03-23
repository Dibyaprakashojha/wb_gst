//package com.uneecops.common.entity;
//
//import java.math.BigDecimal;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
////@Entity
////@Table(name = "gst_ref_reje_amnt_det")
//@SequenceGenerator(name = "ref_rej_amnt_seq", sequenceName = "REF_REJ_AMNT_SEQ", allocationSize = 1)
//public class RefRejectedAmntDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_rej_amnt_seq")
//    @Column(name = "id")
//    private Long id; // Primary Key
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "igst_id", referencedColumnName = "id")
////    private RejRefAmountIgst rejRefAmntIgst;
//    
//	@Column(name = "igst_intrest")
//	private BigDecimal igstintrest;
//	
//	@Column(name = "igst_others")
//	private BigDecimal igstothers;
//	
//	@Column(name = "igst_fee")
//	private BigDecimal igstfee;
//	
//	@Column(name = "igst_penalty")
//	private BigDecimal igstpenalty;
//	
//	@Column(name = "igst_tax")
//	private BigDecimal igsttax;
//	
//	@Column(name = "igst_Total")
//	private BigDecimal igsttot;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "sgst_id", referencedColumnName = "id")
////    private RejRefAmountSgst rejRefAmntSgst;
//	
//	@Column(name = "sgst_intrest")
//	private BigDecimal sgstintrest;
//	
//	@Column(name = "sgst_others")
//	private BigDecimal sgstothers;
//	
//	@Column(name = "sgst_fee")
//	private BigDecimal sgstfee;
//	
//	@Column(name = "sgst_penalty")
//	private BigDecimal sgstpenalty;
//	
//	@Column(name = "sgst_tax")
//	private BigDecimal sgsttax;
//	
//	@Column(name = "sgst_Total")
//	private BigDecimal sgsttot;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "cgst_id", referencedColumnName = "id")
////    private RejRefAmountCgst rejRefAmntCgst;
//	
//	@Column(name = "cgst_intrest")
//	private BigDecimal cgstintrest;
//	
//	@Column(name = "cgst_others")
//	private BigDecimal cgstothers;
//	
//	@Column(name = "cgst_fee")
//	private BigDecimal cgstfee;
//	
//	@Column(name = "cgst_penalty")
//	private BigDecimal cgstpenalty;
//	
//	@Column(name = "cgst_tax")
//	private BigDecimal cgsttax;
//	
//	@Column(name = "cgst_Total")
//	private BigDecimal cgsttot;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "cess_id", referencedColumnName = "id")
////    private RejRefAmountCess rejRefAmntCess;
//	
//	@Column(name = "cess_intrest")
//	private BigDecimal cessintrest;
//	
//	@Column(name = "cess_others")
//	private BigDecimal cessothers;
//	
//	@Column(name = "cess_fee")
//	private BigDecimal cessfee;
//	
//	@Column(name = "cess_penalty")
//	private BigDecimal cesspenalty;
//	
//	@Column(name = "cess_tax")
//	private BigDecimal cesstax;
//	
//	@Column(name = "cgst_Total")
//	private BigDecimal cesstot;
//	
//}
