package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_rfd_payadv_delref_cess")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvdelrfces_seq", sequenceName = "PAYADVDELRFCES_SEQ", allocationSize = 1)
public class PayAdvDelayedRefIntCess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvdelrfces_seq")
    private Long id;

    @Column(name = "intr_cess")  // Mapping to 'intr' in DTO
    private BigDecimal intrestCess;

    @Column(name = "oth_cess")  // Mapping to 'oth' in DTO
    private BigDecimal othersCess;

    @Column(name = "fee_cess")  // Mapping to 'fee' in DTO
    private BigDecimal feeCess;

    @Column(name = "pen_cess")  // Mapping to 'pen' in DTO
    private BigDecimal penaltyCess;

    @Column(name = "tax_cess")  // Mapping to 'tax' in DTO
    private BigDecimal taxCess;

    @Column(name = "tot_cess")  // Mapping to 'tot' in DTO
    private BigDecimal totCess;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
