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
//@Table(name = "GST_RFND_APP_CGSTREFCLAIMDET")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "gst_rfnd_CgstRefClmDet_seq" , sequenceName = "GST_RFND_CGSTREFCLMDET_SEQ" , allocationSize = 1)
public class CgstRefClaimDet extends CommonStatementRefundClaim{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "gst_rfnd_CgstRefClmDet_seq")
	private Long id;
	
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
