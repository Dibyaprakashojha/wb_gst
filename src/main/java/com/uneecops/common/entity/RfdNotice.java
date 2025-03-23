package com.uneecops.common.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "gst_rfnd_notice")
@SequenceGenerator(name = "rfd_notice_seq", sequenceName = "RFD_NOTICE_SEQ", allocationSize = 1)
public class RfdNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_notice_seq")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "refdt")
    @Temporal(TemporalType.DATE)
    private Date refdt;

    @Column(name = "ref_id")
    private String refId;

    @Column(name = "hash")
    private String hash;

    @OneToOne(mappedBy = "rfdNotice", cascade = CascadeType.ALL, orphanRemoval = true)
    private RfdNoticeData rfdNoticeData;
    
 // Many-to-One relationship with Item
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false) // Foreign Key in rfd_notice table
    private Items item;
    
//    @ManyToOne
//    @JoinColumn(name="case_data_id" , nullable =  false)
//    private RfdResponse rfdResponse;
}

