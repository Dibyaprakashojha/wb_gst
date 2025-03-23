package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_sgst_igst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_sgst_igst_seq", sequenceName = "ADJ_SGST_IGST_SEQ", allocationSize = 1)
public class DemandAdjSgstIgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_sgst_igst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
