package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "GST_RFND_PAY_REFERDETAIL")
@SequenceGenerator(name = "pay_ref_seq", sequenceName = "PAY_REF_SEQ", allocationSize = 1)
public class PaymentReferenceDetail  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_ref_seq")
    @Column(name = "payment_ref_id")
    private Long paymentRefId;


    @Column(name = "debit_entry_no", length = 50, nullable = false)
    private String debitEntryNumber;

    @Column(name = "ledger_type", length = 50, nullable = false)
    private String ledgerType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statutory_order_id", nullable = false) // Foreign Key column
    private StatutoryOrderDetails statutoryOrderDetails;
}

