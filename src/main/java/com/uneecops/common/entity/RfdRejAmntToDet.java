package com.uneecops.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gst_rfd_rej_to_det")
@SequenceGenerator(name = "rfd_rej_amnt_to_seq", sequenceName = "RFD_REJ_AMNT_TO_SEQ", allocationSize = 1)
public class RfdRejAmntToDet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rej_amnt_to_seq")
    @Column(name = "id")
    private Long id;  // Primary Keyy

    @JsonProperty("toid")
    @Column(name = "tax_officer_id")
    private String taxOfficerId;

    @JsonProperty("dt")
    @Column(name = "signature_date")
    private String signatureDate;

    @JsonProperty("dg")
    @Column(name = "tax_officer_designation")
    private String taxOfficerDesignation;

    @JsonProperty("signty")
    @Column(name = "tax_officer_sign_type")
    private String taxOfficerSignType;

    @JsonProperty("pl")
    @Column(name = "tax_officer_place")
    private String taxOfficerPlace;

    @JsonProperty("pn")
    @Column(name = "tax_officer_pan_number")
    private String taxOfficerPanNumber;

    @JsonProperty("nm")
    @Column(name = "tax_officer_name")
    private String taxOfficerName;
    
    @OneToOne
    @JoinColumn(name = "rfd_rejected_amnt_data_id", referencedColumnName = "id")
    private RfdRejectedAmntData rfdRejectedAmntData;
}
