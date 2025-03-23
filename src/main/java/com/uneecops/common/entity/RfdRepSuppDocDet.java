package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RFD_REP_SUPP_DOC_DET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rfd_rep_supp_doc_seq", sequenceName = "RFD_REP_SUPP_DOC_SEQ", allocationSize = 1)
public class RfdRepSuppDocDet extends CommonSupportDocDet{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_rep_supp_doc_seq")
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "doc_name", nullable = false)
    private String docName;
    
    @OneToOne
    @JoinColumn(name = "repSuppDoc_id", referencedColumnName = "id", nullable = false)
    private RepSuppDoc repSuppDoc;
}
