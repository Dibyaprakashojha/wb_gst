//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "gst_rfd_payadv_scspec_cess")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "payadvsc_cess_seq", sequenceName = "PAYADVSC_CESS_SEQ", allocationSize = 1)
//public class PayAdvScreenSpecCessData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvsc_cess_seq")
//    private Long id;
//
//    // One-to-One Relationship with PayAdvNetRefAmntSacCess
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "netsancamt_cess_id") // Mapping to 'netsancamt' field
//    private PayAdvNetRefAmntSacCess payAdvNetRefAmntSacCess;
//
//    // One-to-One Relationship with PayAdvDelayedRefIntCess
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "intdlyamt_cess_id") // Mapping to 'intdlyamt' field
//    private PayAdvDelayedRefIntCess payAdvDelayedRefIntCess;
//}
