package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFND_REP_MAIN_DOC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rep_doc_seq", sequenceName = "REP_DOC_SEQ", allocationSize = 1)
public class RepmainDoc extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rep_doc_seq")
    private Long id;

    @Column(name = "doc_name", nullable = false)
    private String docName;

    //One-to-One Relationship with SuppDocumentDetails
    @OneToOne(mappedBy = "repmainDoc", cascade = CascadeType.ALL, orphanRemoval = true)
    private RepSuppDocumentDetails repSuppDocumentDetails;

    //Many-to-One Relationship with RfdReplyData
    @ManyToOne
    @JoinColumn(name = "rfd_reply_data_id" , nullable = false)
    private RfdReplyData rfdReplyData;
}
