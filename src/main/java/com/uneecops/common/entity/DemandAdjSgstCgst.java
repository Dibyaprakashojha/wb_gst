package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_sgst_cgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_sgst_cgst_seq", sequenceName = "ADJ_SGST_CGST_SEQ", allocationSize = 1)
public class DemandAdjSgstCgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_sgst_cgst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
