package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "gst_rfnd_ntc_scrndet")
@SequenceGenerator(name = "screen_details_seq", sequenceName = "SCREEN_DETAILS_SEQ", allocationSize = 1)
public class ScreenDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screen_details_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "type_of_notice")
    private String typeOfNotice;

    @OneToMany(mappedBy = "screenDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InadmissibleRsnSCN> inadmissibleRsnSCN;

    @Column(name = "remarks")
    private String remarks;

    @ElementCollection
    @CollectionTable(name = "reason_list_deficiency", joinColumns = @JoinColumn(name = "screen_details_id"))
    @Column(name = "reason")
    private List<String> reasonListDeficiencMemo;

    @Column(name = "due_date")
    private String duedate;

    @Column(name = "ph_date")
    private String phdt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repextsn_not_id")
    private RplyExtnNotice rplyextnnotice;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ntc_chngbnk_acc_id")
    private NtcChngeBnkAcc ntcChngeBnkAcc;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ntc_ph_rect_id")
    private NtcPersonalHearingDtls ntcPersonalHearingDtls;
}

