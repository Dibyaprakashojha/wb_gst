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
//@Table(name = "GST_RFND_APP_CESSREFCLAIMDET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name ="rfnd_CessRefClmDet_seq" , sequenceName = "RFND_CESSREFCLMDET_SEQ" , allocationSize = 1)
public class CessRefClaimDet extends CommonStatementRefundClaim{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "rfnd_CessRefClmDet_seq" )
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
