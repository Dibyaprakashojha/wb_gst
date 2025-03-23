package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gst_rfnd_ntc_chng_bnkacc")
@SequenceGenerator(name = "ntcchngebnk_seq", sequenceName = "NTCCHNGEBNK_SEQ", allocationSize = 1)
public class NtcChngeBnkAcc extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ntcchngebnk_seq")
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "rsn_issuance_ntc")
    private String rsnIssuanceNtc;
    
    @OneToOne
    @JoinColumn(name = "rfdNoticeData_id", referencedColumnName = "id")
    private RfdNoticeData rfdNoticeData;
}
