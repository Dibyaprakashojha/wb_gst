package com.uneecops.common.entity;

import java.math.BigDecimal;

import com.uneecops.common.enums.PayAdvRefAmount;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_pmntadv_amntdet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadv_amntdet_seq", sequenceName = "PAYADV_AMNTDET_SEQ", allocationSize = 1)
public class PaymAdvAmntDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadv_amntdet_seq")
    private Long id;
    
    @Column(name = "amount_type")
    @Enumerated(EnumType.STRING)
    private PayAdvRefAmount advRefAmount;
   
    
    @Column(name = "igst_intr")  
    private BigDecimal igstIntrest;

    @Column(name = "igst_oth")  
    private BigDecimal igstOthers;

    @Column(name = "igst_fee")  
    private BigDecimal igstFee;

    @Column(name = "igst_pen") 
    private BigDecimal igstPenalty;

    @Column(name = "igst_tax")  
    private BigDecimal igstTax;

    @Column(name = "igst_tot")  
    private BigDecimal igstTot;
    
    @Column(name = "sgst_intr")  
    private BigDecimal sgstIntrest;
    
    @Column(name = "sgst_oth")  
    private BigDecimal sgstOthers;
    
    @Column(name = "sgst_fee")  
    private BigDecimal sgstFee;
    
    @Column(name = "sgst_pen") 
    private BigDecimal sgstPenalty;
    
    @Column(name = "sgst_tax")  
    private BigDecimal sgstTax;
    
    @Column(name = "sgst_tot")  
    private BigDecimal sgstTot;
    
    @Column(name = "cgst_intr")  
    private BigDecimal cgstIntrest;
    
    @Column(name = "cgst_oth")  
    private BigDecimal cgstOthers;
    
    @Column(name = "cgst_fee")  
    private BigDecimal cgstFee;
    
    @Column(name = "cgst_pen") 
    private BigDecimal cgstPenalty;
    
    @Column(name = "cgst_tax")  
    private BigDecimal cgstTax;
    
    @Column(name = "cgst_tot")  
    private BigDecimal cgstTot;
    
    @Column(name = "cess_intr")  
    private BigDecimal cessIntrest;
    
    @Column(name = "cess_oth")  
    private BigDecimal cessOthers;
    
    @Column(name = "cess_fee")  
    private BigDecimal cessFee;
    
    @Column(name = "cess_pen") 
    private BigDecimal cessPenalty;
    
    @Column(name = "cess_tax")  
    private BigDecimal cessTax;
    
    @Column(name = "cess_tot")  
    private BigDecimal cessTot;
    
    
    // Many-to-One Relationship with PayAdvOrderDet
    @ManyToOne
    @JoinColumn(name = "pay_adv_order_id", nullable = false) // Foreign Key
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
    

}
