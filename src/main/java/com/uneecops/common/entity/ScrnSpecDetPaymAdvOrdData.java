//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "gst_rfd_paym_adv_scrndet")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "scrn_spec_det_paym_adv_ord_seq", sequenceName = "SCRN_SPEC_DET_PAYM_ADV_ORD_SEQ", allocationSize = 1)
//public class ScrnSpecDetPaymAdvOrdData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scrn_spec_det_paym_adv_ord_seq")
//    @Column(name = "id")
//    private Long id;
//
//    // One-to-One relationship with PayAdvOrderDet
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "pay_adv_order_id") // Foreign key
//    private PayAdvOrderDet payAdviceOrder;
//}
