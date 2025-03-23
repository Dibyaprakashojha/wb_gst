package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
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
@Table(name = "GST_RFND_APPDATA_STMNT")
@SequenceGenerator(name = "statement_seq", sequenceName = "STATEMENT_SEQ", allocationSize = 1)
public class Statement extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statement_seq")
    @Column(name = "statement_id")
    private Long statementId;

//    //One-to-One with AdjustedTO
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adjusted_turnover_id") // Foreign key in Statement table
//    private AdjustedTO adjustedturnover;
    
    @Column(name = "adj_to_tax")
    private BigDecimal adjustedturnovertax;

//    //One-to-One with InvertedTurnOver
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inverted_turnover_id")
//    private InvertedTurnOver invertedDturnOver;
    
    @Column(name = "inverted_to_tax")
    private BigDecimal invertedDturnOvertax;

//    //One-to-One with ZeroratedTO
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "zerorated_turnover_id")
//    private ZeroratedTurnOver zeroratedturnover;
    
    @Column(name = "zero_to_tax")
    private BigDecimal zeroratedturnovertax;

    //One-to-One with NetITCBal
    @OneToOne(mappedBy = "statement", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "net_itc_bal_id")
    private NetITCBal netITCBal;
    

    //One-to-One with InvertedRatedTax
    @OneToOne(mappedBy = "statement", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "tax_py_bin_inv_id")
    private InvertedRatedTax taxpybinv;
    

    //One-to-One with NetITCDetails
    @OneToOne(mappedBy = "statement", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "net_itc_details_id")
    private NetITCDetails netitc;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;

}
