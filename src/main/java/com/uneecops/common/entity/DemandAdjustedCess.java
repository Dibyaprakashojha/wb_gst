package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_adj_cess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "adj_cess_seq", sequenceName = "ADJ_CESS_SEQ", allocationSize = 1)
public class DemandAdjustedCess extends CommonDemandAdjust_igst_sgst_cgst_cess{

	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adj_cess_seq")
    private Long id;
    
    @Column(name = "adj_order_id", length = 50, nullable = false)
    private String adjustedDemOrderId;
    
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
//    private DemandAdjCessIgst demAdjCessIgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
//    private DemandAdjCessSgst demAdjCessSgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
//    private DemandAdjCessCgst demAdjCessCgst;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
//    private DemandAdjCessCess demAdjCessCess;
    
    
    @ManyToOne
    @JoinColumn(name = "sanctionOrder_id")
    private SanctionOrderDet sanctionOrderDet;
}
