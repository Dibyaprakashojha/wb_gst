package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_REP_SUPP_DOC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rep_supp_doc_seq", sequenceName = "REP_SUPP_DOC_SEQ", allocationSize = 1)
public class RepSuppDoc extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rep_supp_doc_seq")
    private Long id;

    @Column(name = "doc_name" , nullable = false)
    private String docName;

    @OneToOne(mappedBy = "repSuppDoc", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "dcupdtls_id", referencedColumnName = "id")
    private RfdRepSuppDocDet dcupdtls;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rfd_reply_data_id")  // Ensure the column name matches your database schema
    private RfdReplyData rfdReplyData;
}
