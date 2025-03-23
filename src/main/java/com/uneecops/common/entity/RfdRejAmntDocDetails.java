package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gst_rfd_rej_docdet")
@SequenceGenerator(name = "rfd_rej_amnt_doc_seq", sequenceName = "RFD_REJ_AMNT_DOC_SEQ", allocationSize = 1)
public class RfdRejAmntDocDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rej_amnt_doc_seq")
    @Column(name = "id")
    private Long id;  // Primary Key

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "doc_name")
    private String docFileName;

    @Column(name = "doc_id")
    private String docId;

    @Column(name = "hash")
    private String hashCode;
    
    @ManyToOne
    @JoinColumn(name = "rfd_rej_amnt_id", nullable = false)
    private RfdRejectedAmntData rfdRejectedAmntData;
}
