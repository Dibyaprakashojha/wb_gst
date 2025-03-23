package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_REPLY_EXTN_REQ")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "red_repl_extn_seq", sequenceName = "RED_REPL_EXTN_SEQ", allocationSize = 1)
public class RedReplDataRplyextnreq extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "red_repl_extn_seq")
    private Long id;
    @Column(name = "rply_due_date")
    private String rplyduedate;

    @Column(name = "req_due_date")
    private String requestedduedate;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}
