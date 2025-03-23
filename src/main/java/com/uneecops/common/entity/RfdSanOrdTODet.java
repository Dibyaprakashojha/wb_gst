package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gst_rfdsanorder_to_det")
@SequenceGenerator(name = "rfd_san_to_seq", sequenceName = "RFD_SAN_TO_SEQ", allocationSize = 1)
public class RfdSanOrdTODet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_san_to_seq")
    @Column(name = "id")
    private Long id; // Primary Key

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
	@JoinColumn(name = "sancOrdDet_id", nullable = false)
	private SanctionOrderDet sanctionOrderDet;
}
