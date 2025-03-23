package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_cgst_cess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cgst_cess_seq", sequenceName = "GST_RFD_ADJ_CGST_CESS_SEQ", allocationSize = 1)
public class DemandAdjCgstCess extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cgst_cess_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
