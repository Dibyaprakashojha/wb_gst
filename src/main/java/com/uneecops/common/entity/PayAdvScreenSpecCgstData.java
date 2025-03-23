//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "gst_rfnd_payadv_scspec_cgst")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "payadvsc_cgst_seq", sequenceName = "PAYADVSC_CGST_SEQ", allocationSize = 1)
//public class PayAdvScreenSpecCgstData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvsc_cgst_seq")
//    private Long id;
//
//    // One-to-One Relationship with PayAdvNetRefAmntSacCgst
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "netsancamt_cgst_id") // Mapping to 'netsancamt' field
//    private PayAdvNetRefAmntSacCgst payAdvNetRefAmntSacCgst;
//
//    // One-to-One Relationship with PayAdvDelayedRefIntCgst
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "intdlyamt_cgst_id") // Mapping to 'intdlyamt' field
//    private PayAdvDelayedRefIntCgst payAdvDelayedRefIntCgst;
//}
