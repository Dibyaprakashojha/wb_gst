package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "gst_rfd_sanction_orddata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "rfd_san_ord_seq", sequenceName = "RFD_SAN_ORD_SEQ", allocationSize = 1)
public class RfdSanctionOrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_san_ord_seq")
	@Column(name = "id")
	private Long id; // Primary Key

//	// One-to-One relationship with ScrnSpecDetSanctionOrderDataEntity
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "sdtls_id", referencedColumnName = "id")
//	private ScrnSpecDetSanctionOrdData scrnSpecDetSanctionOrderData;

//	// One-to-Many relationship with CommonDocDetailsEntity
//	@OneToMany(mappedBy = "rfdSanctionOrderData", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<RfdSanOrdDataDocDet> commonDocDetails = new ArrayList<>();

//	// One-to-One relationship with CommonTaxOfficerDetEntity
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "todtls_id", referencedColumnName = "id")
//	private RfdSanOrdTODet commonTaxOfficerDet;

	@OneToOne
	@JoinColumn(name = "item_id")
	private Items items;
}
