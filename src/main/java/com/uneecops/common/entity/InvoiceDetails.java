package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GST_RFND_APP_INVOICEDET")
@SequenceGenerator(name = "invoicedetails_seq", sequenceName = "GST_RFND_INVOICEDET_SEQ", allocationSize = 1)
public class InvoiceDetails  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoicedetails_seq")
    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "sgst_amount")
    private BigDecimal sgstAmount;

    @Column(name = "cgst_amount")
    private BigDecimal cgstAmount;

    @Column(name = "igst_amount")
    private BigDecimal igstAmount;

    @Column(name = "cess_amount")
    private BigDecimal cessAmount;

    @Column(name = "invoice_value")
    private BigDecimal invoiceAmount;
    
    @ManyToOne
    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
    private RfndApplicationData rfndApplicationData;
}

