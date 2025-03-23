package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "GST_RFD_ADJ_DEMAND_DET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "adj_demand_seq", sequenceName = "ADJ_DEMAND_SEQ", allocationSize = 1)
public class AdjustedDemand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_demand_seq")
    @Column(name = "adj_demand_id", nullable = false)
    private Long adjustedDemId;

    @Column(name = "adj_order_id", length = 50, nullable = false)
    private String adjustedDemOrderId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
//    private DemandAdjustedIgst demandAdjustedIgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
//    private DemandAdjustedSgst demandAdjustedSgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
//    private DemandAdjustedCgst demandAdjustedCgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
//    private DemandAdjustedCess demandAdjustedCess;
    
    @ManyToOne
    @JoinColumn(name = "sanction_orderdet_id", nullable = false)
    private SanctionOrderDet sanctionOrderDet;
}
