//package com.uneecops.common.entity;
//
//import java.math.BigDecimal;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "GST_RFD_SCREEN_SPEC_IGST")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "screen_spec_igst_seq", sequenceName = "SCREEN_SPEC_IGST_SEQ", allocationSize = 1)
//public class ScreenSpecIGST {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screen_spec_igst_seq")
//    @Column(name = "id")
//    private Long id;
//
////	@OneToOne(cascade = CascadeType.ALL)
////	@JoinColumn(name = "ledger_recredit_amt_id")
////	private LedgerRecreditamtIGST ldgrrecreditamt;
//	
//    @Column(name = "igst_ldgrrecred_total")
//    private BigDecimal igstldgrrecredittotalamt;
//
////	@OneToOne(cascade = CascadeType.ALL)
////	@JoinColumn(name = "inadmissible_amt_id")
////	private InadmissibleAmounIGST inadmamt;
//	
//    @Column(name = "igst_inadmissible_total")
//    private BigDecimal inadmissibletotalamnt;
//
//}
