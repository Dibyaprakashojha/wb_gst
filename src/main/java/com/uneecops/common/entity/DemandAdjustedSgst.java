package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_adj_sgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_sgst_seq", sequenceName = "ADJ_SGST_SEQ", allocationSize = 1)
public class DemandAdjustedSgst extends CommonDemandAdjust_igst_sgst_cgst_cess{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_sgst_seq")
    private Long id;
    
    @Column(name = "adj_order_id", length = 50, nullable = false)
    private String adjustedDemOrderId;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
//    private DemandAdjSgstIgst demAdjSgstIgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
//    private DemandAdjSgstSgst demAdjSgstSgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
//    private DemandAdjSgstCgst demAdjSgstCgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
//    private DemandAdjSgstCess demAdjSgstCess;
    
    
    @ManyToOne
    @JoinColumn(name = "sanctionOrder_id")
    private SanctionOrderDet sanctionOrderDet;
}
