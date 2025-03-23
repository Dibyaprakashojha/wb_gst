package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gst_rfnd_notice_data_docdet")
@SequenceGenerator(name = "noticedoc_seq", sequenceName = "NOTICEDOC_SEQ", allocationSize = 1)
public class NoticeDataDocumentDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noticedoc_seq")
    private Long id;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "doc_file_name")
    private String docFileName;

    @Column(name = "doc_id")
    private String docId;

    @Column(name = "hash_code")
    private String hashCode;

    @ManyToOne
    @JoinColumn(name = "rfdNoticeData_id") // This column will be the FK in the child table
    private RfdNoticeData rfdNoticeData;
}

