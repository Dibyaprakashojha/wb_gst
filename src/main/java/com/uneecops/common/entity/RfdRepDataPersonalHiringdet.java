package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_REP_PERSONAL_HIRING")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rfd_rep_data_phd_seq", sequenceName = "RFD_REP_DATA_PHD_SEQ", allocationSize = 1)
public class RfdRepDataPersonalHiringdet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rep_data_phd_seq")
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "hearing_date")
    private String dateofhearing;

    @Column(name = "hearing_time")
    private String timeofhearing;

    @Column(name = "req_date")
    private String requesteddate;

    @Column(name = "req_time")
    private String requestedtime;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}
