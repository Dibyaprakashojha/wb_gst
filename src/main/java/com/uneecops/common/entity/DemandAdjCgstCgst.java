package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_cgst_cgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cgst_cgst_seq", sequenceName = "ADJ_CGST_CGST_SEQ", allocationSize = 1)
public class DemandAdjCgstCgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cgst_cgst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
