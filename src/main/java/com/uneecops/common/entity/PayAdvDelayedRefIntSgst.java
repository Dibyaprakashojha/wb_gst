package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_rfd_payadv_delayedref_sgst")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvdelrfsgst_seq", sequenceName = "PAYADVDELRFSGST_SEQ", allocationSize = 1)
public class PayAdvDelayedRefIntSgst {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvdelrfsgst_seq")
    private Long id;

    @Column(name = "intr_sgst")  // Mapping to 'intr' in DTO
    private BigDecimal intrest;

    @Column(name = "oth_sgst")  // Mapping to 'oth' in DTO
    private BigDecimal others;

    @Column(name = "fee_sgst")  // Mapping to 'fee' in DTO
    private BigDecimal fee;

    @Column(name = "pen_sgst")  // Mapping to 'pen' in DTO
    private BigDecimal penalty;

    @Column(name = "tax_sgst")  // Mapping to 'tax' in DTO
    private BigDecimal tax;

    @Column(name = "tot_sgst")  // Mapping to 'tot' in DTO
    private BigDecimal tot;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
