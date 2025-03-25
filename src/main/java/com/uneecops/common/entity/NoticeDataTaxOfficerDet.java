package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfnd_ntc_tax_offdet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "noticetaxoff_seq", sequenceName = "NOTICETAXOFF_SEQ", allocationSize = 1)
public class NoticeDataTaxOfficerDet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noticetaxoff_seq")
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
    @JoinColumn(name = "rfdNoticeData_id", referencedColumnName = "id" , nullable = false)
    private RfdNoticeData rfdNoticeData;
    
    
}
