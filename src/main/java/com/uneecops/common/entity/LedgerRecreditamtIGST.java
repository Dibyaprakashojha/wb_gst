package com.uneecops.common.entity;
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
@Table(name = "GST_RFD_REPL_LEDG_RECRE_IGST")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "lgr_rcd_amt_igst_seq", sequenceName = "LGR_RCD_AMT_IGST_SEQ", allocationSize = 1)
public class LedgerRecreditamtIGST  extends CommonStatementRefundClaim{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lgr_rcd_amt_igst_seq")
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}


