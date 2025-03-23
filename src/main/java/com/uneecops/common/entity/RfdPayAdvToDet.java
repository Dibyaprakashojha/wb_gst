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

    @Column(name = "tax_officer_id", nullable = false)
    private String taxOfficerId;

    @Column(name = "signature_date", nullable = false)
    private String signatureDate;

    @Column(name = "tax_officer_designation", nullable = false)
    private String taxOfficerDesignation;

    @Column(name = "tax_officer_sign_type", nullable = false)
    private String taxOfficerSignType;

    @Column(name = "tax_officer_place", nullable = false)
    private String taxOfficerPlace;

    @Column(name = "tax_officer_pan_number", nullable = false)
    private String taxOfficerPanNumber;

    @Column(name = "tax_officer_name", nullable = false)
    private String taxOfficerName;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;

}
