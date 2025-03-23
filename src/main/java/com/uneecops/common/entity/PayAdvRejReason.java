package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gst_rfd_payadv_rejreason")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "payadvrej_seq", sequenceName = "PAYADVREJ_SEQ", allocationSize = 1)
public class PayAdvRejReason {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payadvrej_seq")
    private Long id;

    @Column(name = "rej_reason_code", nullable = false)
    private String rejReaspnCode;

    @Column(name = "rej_reason_desc")
    private String rejReasonDesc;

    // Many-to-One Relationship with PayAdvOrderDet
    @ManyToOne
    @JoinColumn(name = "pay_adv_order_id", nullable = false) // Foreign Key
    private RfdPaymentAdvOrderData rfdPaymentAdvOrderData;
}
