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

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "GST_RFND_APPDATA_STMNTSUMM")
@SequenceGenerator(name = "statement_summary_seq", sequenceName = "STATEMENT_SUMMARY_SEQ", allocationSize = 1)
public class StatementSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statement_summary_seq")
    @Column(name = "summary_id")
    private Long summaryId;

    @Column(name = "total_invoice_amount", precision = 15, scale = 2)
    private BigDecimal totalInvoiceAmount;

    @Column(name = "invoice_count", length = 10)
    private String invoiceCount;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}

