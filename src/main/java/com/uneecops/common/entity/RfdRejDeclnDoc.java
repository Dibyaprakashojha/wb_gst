package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "gst_rfd_rej_declndoc_det")
@SequenceGenerator(name = "rfd_rej_decln_doc_seq", sequenceName = "RFD_REJ_DECLN_DOC_SEQ", allocationSize = 1)
public class RfdRejDeclnDoc extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rej_decln_doc_seq")
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "doc_name")
    private String docFileName;

    @Column(name = "doc_id")
    private String docId;

    @Column(name = "hash_code")
    private String hashCode;
    
    @ManyToOne
    @JoinColumn(name = "rfd_rej_amnt_id", nullable = false)
    private RfdRejectedAmntData rfdRejectedAmntData;
}
