package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_adj_cgst")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cgst_seq", sequenceName = "ADJ_CGST_SEQ", allocationSize = 1)
public class DemandAdjustedCgst extends CommonDemandAdjust_igst_sgst_cgst_cess{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cgst_seq")
    private Long id;
    
    @Column(name = "adj_order_id", length = 50, nullable = false)
    private String adjustedDemOrderId;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
//    private DemandAdjCgstIgst demAdjCgstIgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
//    private DemandAdjCgstSgst demAdjCgstSgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
//    private DemandAdjCgstCgst demAdjCgstCgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
//    private DemandAdjCgstCess demAdjCgstCess;
    
    
    @ManyToOne
    @JoinColumn(name = "sanctionOrder_id")
    private SanctionOrderDet sanctionOrderDet;
}
