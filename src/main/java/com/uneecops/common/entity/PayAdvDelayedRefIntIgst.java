package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_payadv_delay_ref_igst")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvdelrfigst_seq", sequenceName = "PAYADVDELRFIGST_SEQ", allocationSize = 1)
public class PayAdvDelayedRefIntIgst {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvdelrfigst_seq")
    private Long id;

    @Column(name = "intr")  // Mapping to 'intr' in DTO
    private BigDecimal intrest;

    @Column(name = "oth")  // Mapping to 'oth' in DTO
    private BigDecimal others;

    @Column(name = "fee")  // Mapping to 'fee' in DTO
    private BigDecimal fee;

    @Column(name = "pen")  // Mapping to 'pen' in DTO
    private BigDecimal penalty;

    @Column(name = "tax")  // Mapping to 'tax' in DTO
    private BigDecimal tax;

    @Column(name = "tot")  // Mapping to 'tot' in DTO
    private BigDecimal tot;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
