package com.uneecops.common.entity;

import java.util.List;

import com.uneecops.common.converter.StringListConverter;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gst_rfnd_notice_data")
@SequenceGenerator(name = "rfd_notice_data_seq", sequenceName = "RFD_NOTICE_DATA_SEQ", allocationSize = 1)
public class RfdNoticeData extends CommonEntityForAll{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_notice_data_seq")
	private Long id;

	@OneToMany(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "rfd_notice_data_id")
	private List<NoticeDataDocumentDetails> docupdtl;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "screen_details_id", referencedColumnName = "id")
//    private ScreenDetails sdtls;

	@Column(name = "type_of_notice")
	private String typeOfNotice;

	@OneToMany(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InadmissibleRsnSCN> inadmissibleRsnSCN;

	@Column(name = "remarks")
	private String remarks;

	@Convert(converter = StringListConverter.class) // Using converter to convert List<String> into single String with//
													// comma separator
	@Column(name = "reason", columnDefinition = "VARCHAR2(300)")
	private List<String> reasonListDeficiencMemo;

	@Column(name = "due_date")
	private String duedate;

	@Column(name = "ph_date")
	private String phdt;

	@OneToOne(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "repextsn_not_id")
	private RplyExtnNotice rplyextnnotice;

	@OneToOne(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "ntc_chngbnk_acc_id")
	private NtcChngeBnkAcc ntcChngeBnkAcc;

	@OneToOne(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "ntc_ph_rect_id")
	private NtcPersonalHearingDtls ntcPersonalHearingDtls;

	@OneToOne(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "supp_docs_id", referencedColumnName = "id")
	private NoticeDataSuppDoc ntcSuppDoc;

	@OneToOne(mappedBy = "rfdNoticeData", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "tax_officer_details_id", referencedColumnName = "id")
	private NoticeDataTaxOfficerDet taxOfficerdetails;

//    @OneToOne
//    @JoinColumn(name = "rfd_notice_id", referencedColumnName = "id")
//    private RfdNotice rfdNotice;

	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Items item; // Now directly linked to Item
}
