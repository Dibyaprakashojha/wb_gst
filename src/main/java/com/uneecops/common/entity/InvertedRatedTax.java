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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GST_RFND_APP_INVRTAX")
@SequenceGenerator(name = "inv_rated_tax_seq", sequenceName = "INV_RATED_TAX_SEQ", allocationSize = 1)
public class InvertedRatedTax  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inv_rated_tax_seq")
    @Column(name = "inverRatedTax_id")
    private Long inverRatedTaxId;
    
    @Column(name = "tax")
    private BigDecimal tax;
    
    @Column(name = "cess")
    private BigDecimal cess;
    
    @OneToOne
    @JoinColumn(name = "statement_id", referencedColumnName = "statement_id")
    private Statement statement;
}
