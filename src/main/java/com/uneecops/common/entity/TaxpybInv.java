package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "GST_RFND_TAXBYINV")
@SequenceGenerator(name = "taxpybinv_id" , sequenceName = "taxpybinv_id" , allocationSize = 1)
public class TaxpybInv {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "taxpybinv_id")
    @Column(name = "taxpybinv_id")
    private Long taxpybinvId;

    @OneToOne
    @JoinColumn(name = "statement_id", nullable = false)
    private Statement statement;

    @Column(name = "tax", precision = 15, scale = 2)
    private BigDecimal tax;

    @Column(name = "cess", precision = 15, scale = 2)
    private BigDecimal cess;
}

