package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfnd_scrn_spec_igst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "scrn_spec_igst_seq", sequenceName = "SCRN_SPEC_IGST_SEQ", allocationSize = 1)
public class SanOrderScrnSpecIGSTData extends CommonAmountDetForAll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scrn_spec_igst_seq")
    private Long id;
    
    
    @OneToOne
    @JoinColumn(name = "sancOrdDet_id")
    private SanctionOrderDet sanctionOrderDet;
}