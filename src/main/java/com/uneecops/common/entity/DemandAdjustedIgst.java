package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_adj_igst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_igst_seq", sequenceName = "ADJ_IGST_SEQ", allocationSize = 1)
public class DemandAdjustedIgst extends CommonDemandAdjust_igst_sgst_cgst_cess{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_igst_seq")
    private Long id;
    
    @Column(name = "adj_order_id", length = 50, nullable = false)
    private String adjustedDemOrderId;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
//    private DemandAdjIgstIgst demAdjIgstIgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
//    private DemandAdjIgstSgst demAdjIgstSgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
//    private DemandAdjIgstCgst demAdjIgstCgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
//    private DemandAdjIgstCess demAdjIgstCess;
    
    
    @ManyToOne
    @JoinColumn(name = "sanctionOrder_id")
    private SanctionOrderDet sanctionOrderDet;
}
