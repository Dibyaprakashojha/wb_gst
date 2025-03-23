package com.uneecops.common.entity;

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
//@Table(name = "GST_RFND_APP_IGSTREFCLAIMDET")
@SequenceGenerator(name = "rfnd_igstrefclmdet_seq" , sequenceName = "RFND_IGSTREFCLMDET_SEQ" , allocationSize = 1)
public class IgstRefClaimDet extends CommonStatementRefundClaim{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "rfnd_igstrefclmdet_seq") 
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
