//package com.uneecops.common.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Table(name = "GST_RFND_APPDATA_SUPDOCS")
//@SequenceGenerator(name = "rfd_app_supp_doc_seq", sequenceName = "RFD_APP_SUPP_DOC_SEQ", allocationSize = 1)
//public class RfdAppSuppDocument {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_app_supp_doc_seq")
//    @Column(name = "doc_id")
//    private Long docId;
//
//	@Column(name = "doc_name")
//	private String docName;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "document_details_id", referencedColumnName = "supp_doc_id") // Foreign Key
//	private SuppDocumentDetails documentDetails;
//	
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
//    private RfndApplicationData rfndApplicationData;
//
//}
