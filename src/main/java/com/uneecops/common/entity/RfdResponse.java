package com.uneecops.common.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "GST_RFND_CASE_DATA_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name = "rfnd_case_data_seq", sequenceName = "RFND_CASE_DATA_SEQ", allocationSize = 1)
public class RfdResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfnd_case_data_seq")
	@Column(name = "case_data_id")
	private Long CaseDataId;	

	@Column(name = "CASE_TYPE")
	private String casetyCd;

	@Column(name = "STATUS_CODE")
	private String statusCd;

//	@Temporal(TemporalType.DATE)
	@Column(name = "CASE_CREATION_DATE")
	private Date caseCreationDate;
	
    // One-to-Many relationship with Items
    @OneToMany(mappedBy = "rfdResponse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Items> items;

	@Column(name = "GSTIN")
	private String gstin;	

	@Column(name = "CRN")
	private String crn;
}
