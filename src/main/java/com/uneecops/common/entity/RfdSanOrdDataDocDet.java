package com.uneecops.common.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gst_rfd_sanord_docdet")
@SequenceGenerator(name = "rfd_san_doc_seq", sequenceName = "RFD_SAN_DOC_SEQ", allocationSize = 1)
public class RfdSanOrdDataDocDet  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_san_doc_seq")
    @Column(name = "id")
    private Long id; // Primary Key
	
	@Column(name = "cont_type")
	private String contentType;
	
	@Column(name = "type_code")
	private String typeCode;
	
	@Column(name = "doc_name")
	private String docFileName;
	
	@Column(name = "doc_Id")
	private String docId;
	
	@Column(name = "hash")
	private String hashCode;
	
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "rfd_san_order_data_id")
//    private RfdSanctionOrderData rfdSanctionOrderData;
	
	@ManyToOne
	@JoinColumn(name = "sancOrdDet_id", nullable = false)
	private SanctionOrderDet sanctionOrderDet;
}
