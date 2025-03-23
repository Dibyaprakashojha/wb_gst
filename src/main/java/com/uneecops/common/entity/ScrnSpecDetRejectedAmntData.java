//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "gst_rfd_rej_scrnspec_det")
//@SequenceGenerator(name = "scrn_spec_det_rej_amnt_seq", sequenceName = "SCRN_SPEC_DET_REJ_AMNT_SEQ", allocationSize = 1)
//public class ScrnSpecDetRejectedAmntData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scrn_spec_det_rej_amnt_seq")
//    @Column(name = "id")
//    private Long id;  // Primary Key
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rfd_rejcted_amnt_id", referencedColumnName = "id")
//    private RfdRejAmnt rfdRejctedAmnt; // Mapping with RfdRejAmnt entity
//}
