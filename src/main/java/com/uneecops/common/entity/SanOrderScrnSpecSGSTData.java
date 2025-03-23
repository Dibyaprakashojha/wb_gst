package com.uneecops.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Entity
//@Table(name = "gst_rfnd_scrn_spec_sgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "scrn_spec_sgst_seq", sequenceName = "SCRN_SPEC_SGST_SEQ", allocationSize = 1)
public class SanOrderScrnSpecSGSTData extends CommonAmountDetForAll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scrn_spec_sgst_seq")
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "sancOrdDet_id")
    private SanctionOrderDet sanctionOrderDet;
}
