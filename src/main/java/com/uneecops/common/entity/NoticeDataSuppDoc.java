package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gst_rfnd_ntc_supp_doc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "noticesuppdoc_seq", sequenceName = "NOTICESUPPDOC_SEQ", allocationSize = 1)
public class NoticeDataSuppDoc extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noticesuppdoc_seq")
    private Long id;

    @Column(name = "doc_title")
    private String docTitle;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "hash_code")
    private String hashCode;
    
    @OneToOne
    @JoinColumn(name = "rfdNoticeData_id", referencedColumnName = "id" , nullable = false)
    private RfdNoticeData rfdNoticeData;
}
