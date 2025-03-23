package com.uneecops.common.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "gst_rfd_payment_adv")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "rfd_pay_adv_seq", sequenceName = "RFD_PAY_ADV_SEQ", allocationSize = 1)
public class RfdPaymentAdv {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_pay_adv_seq")
    private Long id;



    @Column(name = "item_name", length = 100)
    private String itemName;

    @Column(name = "ref_date")
    private Date refDate;

    @Column(name = "ref_id", length = 50)
    private String refId;

    @Column(name = "ref_hash", length = 255)
    private String refHash;
    
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "case_data_id")
//    private RfdResponse rfdResponse;

    //Many-to-One Relationship with ScreenDetails
    @ManyToOne
    @JoinColumn(name = "Item_Id") // Foreign key
    private Items item;
    
    
}

