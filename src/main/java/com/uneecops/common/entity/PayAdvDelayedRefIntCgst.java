package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_payadv_delay_ref_cgst")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvdelrfcgst_seq", sequenceName = "PAYADVDELRFCGST_SEQ", allocationSize = 1)
public class PayAdvDelayedRefIntCgst {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvdelrfcgst_seq")
    private Long id;

    @Column(name = "intr_cgst")  // Mapping to 'intr' in DTO
    private BigDecimal intrestCgst;

    @Column(name = "oth_cgst")  // Mapping to 'oth' in DTO
    private BigDecimal othersCgst;

    @Column(name = "fee_cgst")  // Mapping to 'fee' in DTO
    private BigDecimal feeCgst;

    @Column(name = "pen_cgst")  // Mapping to 'pen' in DTO
    private BigDecimal penaltyCgst;

    @Column(name = "tax_cgst")  // Mapping to 'tax' in DTO
    private BigDecimal taxCgst;

    @Column(name = "tot_cgst")  // Mapping to 'tot' in DTO
    private BigDecimal totCgst;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
