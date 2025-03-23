//package com.uneecops.common.entity;
//
//import java.math.BigDecimal;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "gst_rfnd_payadv_scspec_igst")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(name = "payadvsc_igst_seq", sequenceName = "PAYADVSC_IGST_SEQ", allocationSize = 1)
//public class PayAdvScreenSpecIgstData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvsc_igst_seq")
//    private Long id;
//
//    // One-to-One Relationship with PayAdvNetRefAmntSac
////    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "netsancamt_id") // Mapping to 'netsancamt' field
////    private PayAdvNetRefAmntSacIgst payAdvNetRefAmntSac;
//    
//
//
////    // One-to-One Relationship with PayAdvDelayedRefInt
////    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "intdlyamt_id") // Mapping to 'intdlyamt' field
////    private PayAdvDelayedRefIntIgst payAdvDelayedRefIntrest;
//    
//
//    
//}
