package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_igst_cess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_igst_cess_seq", sequenceName = "ADJ_IGST_CESS_SEQ", allocationSize = 1)
public class DemandAdjIgstCess extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_igst_cess_seq")
    private Long id;
}
