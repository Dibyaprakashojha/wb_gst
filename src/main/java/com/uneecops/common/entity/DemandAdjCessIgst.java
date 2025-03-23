package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_demand_adj_cess_igst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cess_igst_seq", sequenceName = "GST_RFD_ADJ_IGST_SEQ", allocationSize = 1)
public class DemandAdjCessIgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cess_igst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
}
