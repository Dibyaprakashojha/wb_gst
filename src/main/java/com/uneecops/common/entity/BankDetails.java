package com.uneecops.common.entity;

import java.util.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GST_RFND_APPDATA_BNKDET")
@SequenceGenerator(name = "gst_rfnd_app_bnkdet_seq" , sequenceName = "GST_RFND_APP_BNKDET_SEQ" , allocationSize = 1)
public class BankDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "gst_rfnd_app_bnkdet_seq")
    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
    private RfndApplicationData rfndApplicationData;
    
    @Column(name = "bank_name", length = 100)
    private String bankName;

    @Column(name = "ifsc", length = 15)
    private String ifsc;

    @Column(name = "account_type", length = 10)
    private String accountType;

    @Column(name = "branch_address", length = 255)
    private String branchAddress;

    @Column(name = "reference_number", length = 50)
    private String referenceNumber; 

    @Column(name = "account_type_other", length = 20)
    private String accountTypeOther;

    @Column(name = "original", length = 10)
    private String original;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
}
