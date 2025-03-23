package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_payadv_docdet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "rfd_pay_adv_doc_seq", sequenceName = "RFD_PAY_ADV_DOC_SEQ", allocationSize = 1)
public class RfdPayAdvDocDet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_pay_adv_doc_seq")
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
    @JoinColumn(name = "pay_adv_order_id")
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
