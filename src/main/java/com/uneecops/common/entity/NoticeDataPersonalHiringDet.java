package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "gst_rfnd_repl_extprsnlhrng")
@SequenceGenerator(name = "noticephd_seq", sequenceName = "NOTICEPHD_SEQ", allocationSize = 1)
public class NoticeDataPersonalHiringDet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noticephd_seq")
    private Long id;

	@Column(name = "date_of_hearing")
	private String dateOfHearing;

	@Column(name = "time_of_hearing")
	private String timeOfHearing;

	@Column(name = "requested_date")
	private String requestedDate;

	@Column(name = "requested_time")
	private String requestedTime;
	
    @OneToOne
    @JoinColumn(name = "rplyExtnNotice_id", referencedColumnName = "id")
    private RplyExtnNotice rplyExtnNotice;
}
