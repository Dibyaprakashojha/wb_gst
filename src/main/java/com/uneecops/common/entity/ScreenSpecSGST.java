//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "GST_RFD_SCREEN_SPEC_SGST")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "screen_spec_sgst_seq", sequenceName = "SCREEN_SPEC_SGST_SEQ", allocationSize = 1)
//public class ScreenSpecSGST {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screen_spec_sgst_seq")
//    @Column(name = "id")
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ledger_recredit_amt_sgst_id")
//    private LedgerRecreditamtSGST ldgrrecreditamt;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inadmissible_amt_sgst_id")
//    private InadmissibleAmounSGST inadmamt;
//}
//
