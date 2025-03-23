package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_igst_igst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_igst_igst_seq", sequenceName = "ADJ_IGST_IGST_SEQ", allocationSize = 1)
public class DemandAdjIgstIgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_igst_igst_seq")
    private Long id;
}