package com.uneecops.common.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RFND_CRN_LIST")
public class CrnList {

    @Id
    @Column(name = "CRN")
    private String crn;

    @Column(name = "UPDATE_TIME_STAMP")
    private String updateTmstmp;

    @Column(name = "APPROVAL_AUTHORITY")
    private String approvAuth;

    @Column(name = "CASE_TYPE")
    private String casetyp;

    @Column(name = "STATUS")
    private String status;
    
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updateDate;
	
	//Mapped One To One Relation Ship With Refund Case Data Details MainEntity
	@OneToOne(mappedBy = "crnlist", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private RfdResponse rfdResponse;


    @ManyToOne
    @JoinColumn(name = "TIME_COUNT_ID", nullable = false)
    private TimeCount timeCount; // Foreign key reference
}
