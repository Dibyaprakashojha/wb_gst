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
@Table(name = "gst_rfnd_hrng_ntc")
@SequenceGenerator(name = "ph_rect_ntc_seq", sequenceName = "PH_RECT_NTC_SEQ", allocationSize = 1)
public class NtcPersonalHearingDtls extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ph_rect_ntc_seq")
    private Long id;

	@Column(name = "dateofhearing")
	private String dateofhearing;
	
	@Column(name = "timeofhearing")
	private String timeofhearing;
	
	@Column(name = "requesteddate")
	private String requesteddate;
	
	@Column(name = "requestedtime")
	private String requestedtime;
	
    @OneToOne
    @JoinColumn(name = "rfdNoticeData_id", referencedColumnName = "id" , nullable = false)
    private RfdNoticeData rfdNoticeData;
}
