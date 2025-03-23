package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_payadv_netrefsacamnt_cgst")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvnetrfcgst_seq", sequenceName = "PAYADVNETRFCGST_SEQ", allocationSize = 1)
public class PayAdvNetRefAmntSacCgst {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvnetrfcgst_seq")
    private Long id;

    @Column(name = "intr_cgst")  // Mapping to 'intr' in DTO
    private BigDecimal intrest;

    @Column(name = "oth_cgst")  // Mapping to 'oth' in DTO
    private BigDecimal others;

    @Column(name = "fee_cgst")  // Mapping to 'fee' in DTO
    private BigDecimal fee;

    @Column(name = "pen_cgst")  // Mapping to 'pen' in DTO
    private BigDecimal penalty;

    @Column(name = "tax_cgst")  // Mapping to 'tax' in DTO
    private BigDecimal tax;

    @Column(name = "tot_cgst")  // Mapping to 'tot' in DTO
    private BigDecimal tot;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
