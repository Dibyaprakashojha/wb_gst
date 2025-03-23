package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_igst_sgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_igst_sgst_seq", sequenceName = "ADJ_IGST_SGST_SEQ", allocationSize = 1)
public class DemandAdjIgstSgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_igst_sgst_seq")
    private Long id;
}
