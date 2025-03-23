package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfd_pmnt_advdet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadv_det_seq", sequenceName = "PAYADV_DET_SEQ", allocationSize = 1)
public class PaymAdvDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadv_det_seq")
    private Long id;
//    // One-to-One Mapping with PayAdvScreenSpecIgstData
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "igst_data_id")
//    private PayAdvScreenSpecIgstData payAdvScreenSpecIgstData;
    
    @Column(name = "igst_ref_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal igstRefAmntintrest;

    @Column(name = "igst_ref_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal igstRefAmntothers;

    @Column(name = "igst_ref_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal igstRefAmntfee;

    @Column(name = "igst_ref_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal igstRefAmntpenalty;

    @Column(name = "igst_ref_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal igstRefAmnttax;

    @Column(name = "igst_ref_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal igstRefAmnttot;
    
    @Column(name = "igst_del_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal igstDelAmtintrest;

    @Column(name = "igst_del_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal igstDelAmtothers;

    @Column(name = "igst_del_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal igstDelAmtfee;

    @Column(name = "igst_del_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal igstDelAmtpenalty;

    @Column(name = "igst_del_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal igstDelAmttax;

    @Column(name = "igst_del_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal igstDelAmttot;

    // One-to-One Mapping with PayAdvScreenSpecCgstData
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "cgst_data_id")
//    private PayAdvScreenSpecCgstData payAdvScreenSpecCgstData;
    
    @Column(name = "cgst_ref_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal cgstRefAmntintrest;

    @Column(name = "cgst_ref_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal cgstRefAmntothers;

    @Column(name = "cgst_ref_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal cgstRefAmntfee;

    @Column(name = "cgst_ref_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal cgstRefAmntpenalty;

    @Column(name = "cgst_ref_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal cgstRefAmnttax;

    @Column(name = "cgst_ref_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal cgstRefAmnttot;
    
    @Column(name = "cgst_del_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal cgstDelAmtintrest;

    @Column(name = "cgst_del_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal cgstDelAmtothers;

    @Column(name = "cgst_del_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal cgstDelAmtfee;

    @Column(name = "cgst_del_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal cgstDelAmtpenalty;

    @Column(name = "cgst_del_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal cgstDelAmttax;

    @Column(name = "cgst_del_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal cgstDelAmttot;

    // One-to-One Mapping with PayAdvScreenSpecSgstData
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "sgst_data_id")
//    private PayAdvScreenSpecSgstData payAdvScreenSpecSgstData;
    
    
    @Column(name = "sgst_ref_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal sgstRefAmntintrest;

    @Column(name = "sgst_ref_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal sgstRefAmntothers;

    @Column(name = "sgst_ref_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal sgstRefAmntfee;

    @Column(name = "sgst_ref_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal sgstRefAmntpenalty;

    @Column(name = "sgst_ref_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal sgstRefAmnttax;

    @Column(name = "sgst_ref_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal sgstRefAmnttot;
    
    @Column(name = "sgst_del_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal sgstDelAmtintrest;

    @Column(name = "sgst_del_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal sgstDelAmtothers;

    @Column(name = "sgst_del_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal sgstDelAmtfee;

    @Column(name = "sgst_del_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal sgstDelAmtpenalty;

    @Column(name = "sgst_del_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal sgstDelAmttax;

    @Column(name = "sgst_del_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal sgstDelAmttot;

    // One-to-One Mapping with PayAdvScreenSpecCessData
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "cess_data_id")
//    private PayAdvScreenSpecCessData payAdvScreenSpecCessData;
    
    
    @Column(name = "cess_ref_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal cessRefAmntintrest;

    @Column(name = "cess_ref_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal cessRefAmntothers;

    @Column(name = "cess_ref_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal cessRefAmntfee;

    @Column(name = "cess_ref_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal cessRefAmntpenalty;

    @Column(name = "cess_ref_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal cessRefAmnttax;

    @Column(name = "cess_ref_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal cessRefAmnttot;
    
    @Column(name = "cess_del_amnt_intr")  // Mapping to 'intr' in DTO
    private BigDecimal cessDelAmtintrest;

    @Column(name = "cess_del_amnt_oth")  // Mapping to 'oth' in DTO
    private BigDecimal cessDelAmtothers;

    @Column(name = "cess_del_amnt_fee")  // Mapping to 'fee' in DTO
    private BigDecimal cessDelAmtfee;

    @Column(name = "cess_del_amnt_pen")  // Mapping to 'pen' in DTO
    private BigDecimal cessDelAmtpenalty;

    @Column(name = "cess_del_amnt_tax")  // Mapping to 'tax' in DTO
    private BigDecimal cessDelAmttax;

    @Column(name = "cess_del_amnt_tot")  // Mapping to 'tot' in DTO
    private BigDecimal cessDelAmttot;
}
