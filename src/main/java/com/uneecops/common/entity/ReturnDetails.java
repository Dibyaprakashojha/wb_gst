package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GST_RFND_RETURN_DETAILS")
@SequenceGenerator(name = "return_det_seq", sequenceName = "RETURN_DET_SEQ", allocationSize = 1)
public class ReturnDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "return_det_seq")
    @Column(name = "return_id")
    private Long returnId;

    @Column(name = "return_type", length = 50, nullable = false)
    private String returnType;

    @Column(name = "tax_period", length = 6, nullable = false)
    private String fromTaxPeriod;

    @Column(name = "return_filing_date", length = 20, nullable = false)
    private String date;  // Storing as String assuming formatted date is needed

    @Column(name = "arn", length = 50)
    private String arn;

    @Column(name = "igst", precision = 15, scale = 2)
    private BigDecimal igst;

    @Column(name = "cgst", precision = 15, scale = 2)
    private BigDecimal cgst;

    @Column(name = "sgst", precision = 15, scale = 2)
    private BigDecimal sgst;

    @ManyToOne
    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
    private RfndApplicationData rfndApplicationData;
    
    @Column(name = "cess", precision = 15, scale = 2)
    private BigDecimal cess;
}
