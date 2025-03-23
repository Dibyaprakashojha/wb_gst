//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "gst_rfdpayadv_scspec_sgst")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "payadvsc_sgst_seq", sequenceName = "PAYADVSC_SGST_SEQ", allocationSize = 1)
//public class PayAdvScreenSpecSgstData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvsc_sgst_seq")
//    private Long id;
//
//    // One-to-One Relationship with PayAdvNetRefAmntSacSgst
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "netsancamt_sgst_id") // Mapping to 'netsancamt' field
//    private PayAdvNetRefAmntSacSgst payAdvNetRefAmntSacSgst;
//
//    // One-to-One Relationship with PayAdvDelayedRefIntSgst
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "intdlyamt_sgst_id") // Mapping to 'intdlyamt' field
//    private PayAdvDelayedRefIntSgst payAdvDelayedRefIntSgst;
//}
