package com.uneecops.common.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "GST_RFND_REPLY")
@SequenceGenerator(name = "rfd_reply_seq", sequenceName = "RFD_REPLY_SEQ", allocationSize = 1)
public class RfdReply {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_reply_seq")
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "item_name")
    private String itemName;



    @Column(name = "ref_id")
    private String refid;

    @Column(name = "ref_dt")
    @Temporal(TemporalType.DATE)
    private Date refdt;

    @Column(name = "hash")
    private String hash;
    
    //Many-to-One connection with Items (because multiple replies belong to one item)
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Items item;
    
//    @ManyToOne
//    @JoinColumn(name="case_data_id" , nullable =  false)
//    private RfdResponse rfdResponse;
}
