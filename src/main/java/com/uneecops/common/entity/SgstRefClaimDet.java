package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "GST_RFND_APP_SGSTREFCLAIMDET")
@SequenceGenerator(name = "sgst_ref_claim_seq", sequenceName = "SGST_REF_CLAIM_SEQ", allocationSize = 1)
public class SgstRefClaimDet extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgst_ref_claim_seq")
    @Column(name = "id")
    private Long id; // Primary Key
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
