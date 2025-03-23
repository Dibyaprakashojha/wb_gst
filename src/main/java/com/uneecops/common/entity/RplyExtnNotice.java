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
@Entity
@Table(name = "gst_rfnd_rply_extn_notice")
@SequenceGenerator(name = "rply_extn_notice_seq", sequenceName = "RPLY_EXTN_NOTICE_SEQ", allocationSize = 1)
public class RplyExtnNotice extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rply_extn_notice_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "notice_type", length = 100, nullable = false)
    private String noticeType;

//    @OneToOne(mappedBy = "rplyExtnNotice", cascade = CascadeType.ALL, orphanRemoval = true)
// //   @JoinColumn(name = "rply_extn_req_id", referencedColumnName = "id")
//    private NoticeDataRplyExtnReq rplyExtnReq;
    
    @Column(name = "rply_due_date")
    private String rplyDueDate;

    @Column(name = "requested_due_date")
    private String requestedDueDate;

    @Column(name = "action", length = 50)
    private String action;

    @Column(name = "ntc_ref_id", length = 100)
    private String ntcRefid;

    @Column(name = "ntc_date", length = 20)
    private String ntcDate;

    @Column(name = "reply_id", length = 100)
    private String replyId;

    @Column(name = "reply_date", length = 20)
    private String replydt;
    
	@Column(name = "date_of_hearing")
	private String dateOfHearing;

	@Column(name = "time_of_hearing")
	private String timeOfHearing;

	@Column(name = "hrng_rqstd_dt")
	private String requestedDate;

	@Column(name = "hrng_rqstd_tm")
	private String requestedTime;

//    @OneToOne(mappedBy = "rplyExtnNotice", cascade = CascadeType.ALL, orphanRemoval = true)
//   // @JoinColumn(name = "prsnl_hrng_id", referencedColumnName = "id")
//    private NoticeDataPersonalHiringDet prsnlhrng;
    
    @OneToOne
    @JoinColumn(name = "rfdNoticeData_id", referencedColumnName = "id")
    private RfdNoticeData rfdNoticeData;
}

