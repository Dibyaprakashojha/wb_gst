//package com.uneecops.common.entity;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "GST_RFD_SCREEN_SPEC_CGST")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "screenspecific_cgst_seq", sequenceName = "SCREEN_SPECIFIC_CGST_SEQ", allocationSize = 1)
//public class ScreenspecificCGST {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screenspecific_cgst_seq")
//    @Column(name = "id")
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ledger_recredit_amt_cgst_id")
//    private LedgerRecreditamountCGST ledgerRecreditamtCGST;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inadmissible_amt_cgst_id")
//    private InadmissibleAmountCGST inadmissibleAtCGST;
//}
//
