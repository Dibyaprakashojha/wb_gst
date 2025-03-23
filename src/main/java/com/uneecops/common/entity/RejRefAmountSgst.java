package com.uneecops.common.entity;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "gst_rfd_rejamnt_sgst")
@SequenceGenerator(name = "rej_ref_amt_sgst_seq", sequenceName = "REJ_REF_AMT_SGST_SEQ", allocationSize = 1)
public class RejRefAmountSgst extends CommonStatementRefundClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rej_ref_amt_sgst_seq")
    @Column(name = "id")
    private Long id; // Primary Key
    
    @OneToOne
    @JoinColumn(name = "rfd_rejected_amnt_data_id", referencedColumnName = "id")
    private RfdRejectedAmntData rfdRejectedAmntData;
}
