package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_demand_adj_cess_cess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cess_cess_seq", sequenceName = "GST_RFD_ADJ_CESS_SEQ", allocationSize = 1)
public class DemandAdjCessCess extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cess_cess_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
