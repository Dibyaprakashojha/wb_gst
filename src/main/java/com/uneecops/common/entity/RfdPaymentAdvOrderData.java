package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "gst_rfd_pmntadv_order_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "rfd_pay_adv_order_seq", sequenceName = "RFD_PAY_ADV_ORDER_SEQ", allocationSize = 1)
public class RfdPaymentAdvOrderData extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_pay_adv_order_seq")
    private Long id;

//    // One-to-One relationship with ScrnSpecDetPaymAdvOrdData
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "sc_spec_details_id") // Foreign key
//    private ScrnSpecDetPaymAdvOrdData scrnSpecDetCompAdmntOrdData;
    
    @Column(name = "order_type")
    private String orderType;

    @Column(name = "rfd_order_type")
    private String rfdOrderType;

    @Column(name = "cwf_initiated_indicator")
    private Boolean cwfInitiatedIndicator;

    @Column(name = "rfd_pro_san_ord_no")
    private String rfdProSanOrdNo;

    @Column(name = "prev_paym_adv_no")
    private String prevPaymAdvNo;

    // One-to-Many Relationship with PaymAdvDetails
    @OneToMany(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymAdvAmntDetails> paymAdvAmtDet;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvDelayedRefIntCess advDelayedRefIntCess;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvDelayedRefIntCgst advDelayedRefIntCgst;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvDelayedRefIntIgst advDelayedRefIntIgst;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvDelayedRefIntSgst advDelayedRefIntSgst;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvNetRefAmntSacCess advNetRefAmntSacCess;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvNetRefAmntSacCgst advNetRefAmntSacCgst;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvNetRefAmntSacIgst advNetRefAmntSacIgst;
    
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayAdvNetRefAmntSacSgst advNetRefAmntSacSgst;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "pay_adv_status")
    private String payAdvStatus;

    // One-to-Many Relationship with PayAdvRejReason
    @OneToMany(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PayAdvRejReason> payAdvRejReason;

    @Column(name = "disbursed_amount", precision = 15, scale = 2)
    private BigDecimal disbursedAmnt;

    // One-to-Many relationship with RfdPayAdvDocDet
    @OneToMany(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RfdPayAdvDocDet> commonDocDetails;

    // One-to-One relationship with RfdPayAdvToDet
    @OneToOne(mappedBy = "rfdPaymentAdvOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "tax_officer_details_id") // Foreign key
    private RfdPayAdvToDet commonTaxOfficerDet;
    
//    @OneToOne
//    @JoinColumn(name = "rfdPaymentAdv_id")
//    private RfdPaymentAdv rfdPaymentAdv;
    
	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Items item; // Now directly linked to Item
}
