package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "GST_RFND_APPDATA_SUPDOCDETAILS")
@SequenceGenerator(name = "supp_doc_seq", sequenceName = "SUPP_DOCUMENT_SEQ", allocationSize = 1)
public class SuppDocumentDetails extends CommonSupportDocDet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supp_doc_seq")
    @Column(name = "supp_doc_id")
    private Long id; // Fixed variable name (id instead of Id)
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
    private RfndApplicationData rfndApplicationData;
}
