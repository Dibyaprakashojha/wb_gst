//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Entity
//@Table(name = "gst_rfnd_pmntadv_orddet")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "payadvorder_seq", sequenceName = "PAYADVORDER_SEQ", allocationSize = 1)
//public class PayAdvOrderDet {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvorder_seq")
//    private Long id;
//
//    @Column(name = "order_type")
//    private String orderType;
//
//    @Column(name = "rfd_order_type")
//    private String rfdOrderType;
//
//    @Column(name = "cwf_initiated_indicator")
//    private Boolean cwfInitiatedIndicator;
//
//    @Column(name = "rfd_pro_san_ord_no")
//    private String rfdProSanOrdNo;
//
//    @Column(name = "prev_paym_adv_no")
//    private String prevPaymAdvNo;
//
//    // One-to-One Relationship with PaymAdvDetails
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "paym_adv_details_id") // Foreign key
//    private PaymAdvDetails paymAdvDet;
//
//    @Column(name = "remarks")
//    private String remarks;
//
//    @Column(name = "pay_adv_status")
//    private String payAdvStatus;
//
//    // One-to-Many Relationship with PayAdvRejReason
//    @OneToMany(mappedBy = "payAdvOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PayAdvRejReason> payAdvRejReason;
//
//    @Column(name = "disbursed_amount", precision = 15, scale = 2)
//    private BigDecimal disbursedAmnt;
//}
