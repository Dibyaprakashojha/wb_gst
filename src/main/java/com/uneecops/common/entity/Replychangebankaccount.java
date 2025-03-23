package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_REP_CHNGBNK_ACC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "reply_chg_bnk_seq", sequenceName = "REPLY_CHG_BNK_SEQ", allocationSize = 1)
public class Replychangebankaccount extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_chg_bnk_seq")
    private Long id;

    @Column(name = "bank_hol_acc_name", length = 255, nullable = false)
    private String bankHolAccName;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}
