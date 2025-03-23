package com.uneecops.common.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GST_RFND_STATUTORY_ORDET")
@SequenceGenerator(name = "statutory_order_seq", sequenceName = "STATUTORY_ORDER_SEQ", allocationSize = 1)
public class StatutoryOrderDetails extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statutory_order_seq")
    @Column(name = "statutory_order_id")
    private Long statutoryOrderId;

    @Column(name = "order_number", length = 50, nullable = false)
    private String orderNum;

    @Column(name = "demand_id", length = 50)
    private String demandId;

    @Column(name = "order_issuing_auth", length = 100, nullable = false)
    private String orderIssuingAuth;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "other_order_number", length = 50)
    private String otherOrderNumb;

    @Column(name = "type_of_order", length = 50, nullable = false)
    private String typeOfOrder;

    // One-to-Many Relationship with PaymentReferenceDetail
    @OneToMany(mappedBy = "statutoryOrderDetails", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PaymentReferenceDetail> paymentReferenceDetails;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
    
}

