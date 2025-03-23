package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFND_REP_SUPPDOC_DET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rep_supp_doc_det_seq", sequenceName = "REP_SUPP_DOC_DET_SEQ", allocationSize = 1)
public class RepSuppDocumentDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rep_supp_doc_det_seq")
    private Long id;

    @Column(name = "doc_name")
    private String docName;

    @Column(name = "doc_id")
    private String docid;

    @Column(name = "doc_type_code")
    private String docTypeCode;

    @Column(name = "doc_title")
    private String docTtl;

    @Column(name = "doc_content_type")
    private String docContentType;

    @Column(name = "hash")
    private String hash;
    
    @OneToOne
    @JoinColumn(name = "repmain_doc_id", referencedColumnName = "id", nullable = false)
    private RepmainDoc repmainDoc;
}
