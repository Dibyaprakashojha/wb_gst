//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//@Entity
//@Table(name = "GST_RFD_SCREEN_SPEC_CESS")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "screen_speccess_seq", sequenceName = "SCREEN_SPECCESS_SEQ", allocationSize = 1)
//public class ScreenSpeccess {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screen_speccess_seq")
//    @Column(name = "id")
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ledger_recredit_amt_cess_id")
//    private LedgerRecreditamountcess ledgerRecreditamtcess;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inadmissible_amt_cess_id")
//    private InadmissibleAmountcess inadmissibleAtcess;
//}
//
