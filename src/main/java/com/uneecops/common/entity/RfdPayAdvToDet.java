package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_payadv_todet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "rfd_pay_adv_to_seq", sequenceName = "RFD_PAY_ADV_TO_SEQ", allocationSize = 1)
public class RfdPayAdvToDet  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_pay_adv_to_seq")
    private Long id;

    @Column(name = "tax_officer_id")
    private String taxOfficerId;

    @Column(name = "signature_date")
    private String signatureDate;

    @Column(name = "tax_officer_designation")
    private String taxOfficerDesignation;

    @Column(name = "tax_officer_sign_type")
    private String taxOfficerSignType;

    @Column(name = "tax_officer_place")
    private String taxOfficerPlace;

    @Column(name = "tax_officer_pan_number")
    private String taxOfficerPanNumber;

    @Column(name = "tax_officer_name")
    private String taxOfficerName;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;

}
