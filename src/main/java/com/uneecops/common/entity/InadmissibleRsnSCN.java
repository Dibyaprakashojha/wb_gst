package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gst_rfnd_ntc_inadmisrsn_scn")
@SequenceGenerator(name = "inad_rsn_scn_seq", sequenceName = "INAD_RSN_SCN_SEQ", allocationSize = 1)
public class InadmissibleRsnSCN extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inad_rsn_scn_seq")
    private Long id;

    @Column(name = "reason")
    private String reasonInadmissibleSCN;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amountReasonInadmissible;

    @Column(name = "check_status")
    private Boolean checkStatus;

    @Column(name = "name", length = 255)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "rfdNoticeData_id") // This column will be the FK in the child table
    private RfdNoticeData rfdNoticeData; // Reference to Parent Entity
}

