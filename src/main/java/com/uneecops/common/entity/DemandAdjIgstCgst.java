package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_igst_cgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_igst_cgst_seq", sequenceName = "ADJ_IGST_CGST_SEQ", allocationSize = 1)
public class DemandAdjIgstCgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_igst_cgst_seq")
    private Long id;
}
