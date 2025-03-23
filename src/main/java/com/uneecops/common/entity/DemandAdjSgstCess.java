package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_adj_sgst_cess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_sgst_cess_seq", sequenceName = "ADJ_SGST_CESS_SEQ", allocationSize = 1)
public class DemandAdjSgstCess extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_sgst_cess_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
