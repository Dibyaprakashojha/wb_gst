package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_cgst_sgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cgst_sgst_seq", sequenceName = "ADJ_CGST_SGST_SEQ", allocationSize = 1)
public class DemandAdjCgstSgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cgst_sgst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
