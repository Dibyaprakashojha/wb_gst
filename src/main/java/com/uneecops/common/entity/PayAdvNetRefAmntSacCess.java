package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gst_rfd_payadv_netrefamnt_cess")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvnetrfcess_seq", sequenceName = "PAYADVNETRFCESS_SEQ", allocationSize = 1)
public class PayAdvNetRefAmntSacCess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvnetrfcess_seq")
    private Long id;

    @Column(name = "intr_cess")  // Mapping to 'intr' in DTO
    private BigDecimal intrest;

    @Column(name = "oth_cess")  // Mapping to 'oth' in DTO
    private BigDecimal others;

    @Column(name = "fee_cess")  // Mapping to 'fee' in DTO
    private BigDecimal fee;

    @Column(name = "pen_cess")  // Mapping to 'pen' in DTO
    private BigDecimal penalty;

    @Column(name = "tax_cess")  // Mapping to 'tax' in DTO
    private BigDecimal tax;

    @Column(name = "tot_cess")  // Mapping to 'tot' in DTO
    private BigDecimal tot;
    
    @OneToOne
    @JoinColumn(name = "payAdvOrdData_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
