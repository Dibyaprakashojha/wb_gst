package com.uneecops.common.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gst_rfnd_sancorder_det")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sanction_order_det_seq", sequenceName = "SANCTION_ORDER_DET_SEQ", allocationSize = 1)
public class SanctionOrderDet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sanction_order_det_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "order_type")
    private String refundOrderType;

//    @OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<AdjustedDemand> adjustedDemDet;

    
    @OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "adj_igst_id", referencedColumnName = "id")
    private List<DemandAdjustedIgst> demandAdjustedIgst;

    @OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
 //   @JoinColumn(name = "adj_sgst_id", referencedColumnName = "id")
    private List<DemandAdjustedSgst> demandAdjustedSgst;

    @OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "adj_cgst_id", referencedColumnName = "id")
    private List<DemandAdjustedCgst> demandAdjustedCgst;

    @OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
 //   @JoinColumn(name = "adj_cess_id", referencedColumnName = "id")
    private List<DemandAdjustedCess> demandAdjustedCess;
    
    
    @ElementCollection
    @CollectionTable(name = "sanction_order_inadmreason", joinColumns = @JoinColumn(name = "sanction_order_id"))
    @Column(name = "inadm_reason")
    private List<String> inadmreason;

    @Column(name = "other_reason")
    private String otherReason;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "ref_amt_screen_data_id", referencedColumnName = "id")
//    private RefAmtScreenDataEntity refAmtScreenData;
    
//    @OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private SanOrderScrnSpecIGSTData scrnSpecIGSTData;  
//
//    @OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private SanOrderScrnSpecCGSTData scrnSpecCGSTData;  
//  
//    @OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private SanOrderScrnSpecSGSTData scrnSpecSGSTData;
//    
//    @OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private SanOrderScrnSpecCESSData scrnSpecCESSData;
    
    @OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SanctionAmntDetails sanctionAmntDetails;  
    
	@OneToMany(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RfdSanOrdDataDocDet> commonDocDetails;
	
	// One-to-One relationship with CommonTaxOfficerDetEntity
	@OneToOne(mappedBy = "sanctionOrderDet", cascade = CascadeType.ALL, orphanRemoval = true)
	private RfdSanOrdTODet commonTaxOfficerDet;

    @Column(name = "cwf_flag")
    private Boolean cwfflag;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "risk_exp_alert")
    private String riskExpAlert;

    @Column(name = "risk_exp_marks")
    private String riskExpMarks;
    
	@OneToOne
	@JoinColumn(name = "item_id")
	private Items items;
}
