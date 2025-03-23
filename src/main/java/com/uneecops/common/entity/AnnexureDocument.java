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
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "GST_RFND_ANNEXDOC")
//@SequenceGenerator(name = "annex_doc_id_seq", sequenceName = "ANNEX_DOC_ID_SEQ", allocationSize = 1)
//public class AnnexureDocument {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY , generator = "annex_doc_id_seq")
//	@Column(name = "doc_id")
//	private Long docId;
//
//
//    @Column(name = "doc_name", nullable = false)
//    private String docName;
//
//    @OneToOne(cascade = CascadeType.ALL)  
//    @JoinColumn(name = "document_details_id", referencedColumnName = "id")  
//    private AnnexureDocumentDetails annexureDocumentDetails;  // Linking with AnnexureDocumentDetails entity
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
//    private RfndApplicationData rfndApplicationData;
//}
