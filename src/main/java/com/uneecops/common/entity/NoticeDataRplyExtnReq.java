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
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "gst_rfnd_rply_extn_req")
@SequenceGenerator(name = "noticerr_seq", sequenceName = "NOTICERR_SEQ", allocationSize = 1)
public class NoticeDataRplyExtnReq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noticerr_seq")
    private Long id;

    @Column(name = "rply_due_date")
    private String rplyDueDate;

    @Column(name = "requested_due_date")
    private String requestedDueDate;
    
    @OneToOne
    @JoinColumn(name = "rplyExtnNotice_id", referencedColumnName = "id")
    private RplyExtnNotice rplyExtnNotice;
}
