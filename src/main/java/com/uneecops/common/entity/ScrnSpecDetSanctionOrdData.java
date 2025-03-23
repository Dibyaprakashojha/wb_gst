package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_sancord_scrnspec_det")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "scrn_spec_det_san_ord_seq", sequenceName = "SCRN_SPEC_DET_SAN_ORD_SEQ", allocationSize = 1)
public class ScrnSpecDetSanctionOrdData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scrn_spec_det_san_ord_seq")
    @Column(name = "id")
    private Long id; // Primary Key
    // One-to-One relationship with SanctionOrderDetEntity
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sanc_order_det_id", referencedColumnName = "id")
    private SanctionOrderDet sanctionOrderDet;
    
}
