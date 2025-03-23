//package com.uneecops.common.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "gst_rfd_rej_amnt")
//@SequenceGenerator(name = "rfd_rej_amnt_seq", sequenceName = "RFD_REJ_AMNT_SEQ", allocationSize = 1)
//public class RfdRejAmnt {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rej_amnt_seq")
//    @Column(name = "id")
//    private Long id; // Primary Key
//
//    @Column(name = "order_type")
//    private String orderType;
//
//    @Column(name = "rfd_pro_san_order_no")
//    private String rfdProSanOrderNo;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reje_amnt_det_id", referencedColumnName = "id")
//    private RefRejectedAmntDetails refRejectedAmntDetails;
//
//    @Column(name = "remarks")
//    private String remarks;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rfd_rej_amnt_id")
//    private List<RfdRejDeclnDoc> declarationDoc; // List of Declaration Documents
//}
