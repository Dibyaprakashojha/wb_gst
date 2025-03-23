package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_SCN_REPLY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "scn_reply_seq", sequenceName = "SCN_REPLY_SEQ", allocationSize = 1)
public class ScnReply extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scn_reply_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "rep_text")
    private String repText;

    @Column(name = "remarks")
    private String remarks;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}
