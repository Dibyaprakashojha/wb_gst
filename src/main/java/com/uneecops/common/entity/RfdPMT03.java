package com.uneecops.common.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
//@Table(name = "gst_rfd_pmt_03")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "rfd_pmt03_seq", sequenceName = "RFD_PMT03_SEQ", allocationSize = 1)
public class RfdPMT03 extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_pmt03_seq")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "ref_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date refDt;

    @Column(name = "ref_id")
    private String refId;

    @Column(name = "hash")
    private String hash;



    // Many-to-One relationship with Item
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false) // Foreign Key in rfd_notice table
    private Items item;
    
//    @ManyToOne
//    @JoinColumn(name="case_data_id" , nullable =  false)
//    private RfdResponse rfdResponse;
}
