//package com.uneecops.common.entity;
//
//import java.math.BigDecimal;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "GST_RFD_UNDRTKNG_AMTDET")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "undertaking_amt_seq", sequenceName = "UNDERTAKING_AMT_SEQ", allocationSize = 1)
//public class UndertakingAmtDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "undertaking_amt_seq")
//    @Column(name = "id")
//    private Long id;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "igst_id")
////    private ScreenSpecIGST screenspecIGSTdata;
//    
//    @Column(name = "igst_ldgrrecred_total")
//    private BigDecimal igstldgrrecredittot;
//    
//    @Column(name = "igst_ldgrrecred_intr")
//	private BigDecimal igstldgrrecreditintrest;
//	
//    @Column(name = "igst_ldgrrecred_oth")
//	private BigDecimal igstldgrrecreditothers;
//	
//    @Column(name = "igst_ldgrrecred_fee")
//	private BigDecimal igstldgrrecreditfee;
//	
//    @Column(name = "igst_ldgrrecred_pen")
//	private BigDecimal igstldgrrecreditpenalty;
//	
//    @Column(name = "igst_ldgrrecred_tax")
//	private BigDecimal igstldgrrecredittax;
//    
//    @Column(name = "igst_inadmissible_total")
//    private BigDecimal igstinadmissibletotalamnt;
//    
//    @Column(name = "igst_ldgrrecred_intr")
//	private BigDecimal igstldgrrecreditintrest;
//	
//    @Column(name = "igst_ldgrrecred_oth")
//	private BigDecimal igstldgrrecreditothers;
//	
//    @Column(name = "igst_ldgrrecred_fee")
//	private BigDecimal igstldgrrecreditfee;
//	
//    @Column(name = "igst_ldgrrecred_pen")
//	private BigDecimal igstldgrrecreditpenalty;
//	
//    @Column(name = "igst_ldgrrecred_tax")
//	private BigDecimal igstldgrrecredittax;
//    
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "cgst_id")
////    private ScreenspecificCGST screenspecificCGSTdata;
//    
//    @Column(name = "cgst_ldgrrecred_total")
//    private BigDecimal cgstldgrrecredittotalamt;
//    
//    @Column(name = "cgst_inadmissible_total")
//    private BigDecimal cgstinadmissibletotalamnt;
////
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "sgst_id")
////    private ScreenSpecSGST screenSpecSGST;
//    
//    @Column(name = "sgst_ldgrrecred_total")
//    private BigDecimal sgstldgrrecredittotalamt;
//    
//    @Column(name = "sgst_inadmissible_total")
//    private BigDecimal sgstinadmissibletotalamnt;
//    
////
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "cess_id")
////    private ScreenSpeccess screenSpeccess;
//    
//    @Column(name = "cess_ldgrrecred_total")
//    private BigDecimal cessldgrrecredittotalamt;
//    
//    @Column(name = "cess_inadmissible_total")
//    private BigDecimal cessinadmissibletotalamnt;
//    
//    
//}
