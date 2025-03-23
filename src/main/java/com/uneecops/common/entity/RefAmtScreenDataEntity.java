package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "gst_rfnd_amt_screen_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "amt_screen_seq", sequenceName = "AMT_SCREEN_SEQ", allocationSize = 1)
public class RefAmtScreenDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amt_screen_seq")
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "scrn_spec_igst_id", referencedColumnName = "id")
//    private SanOrderScrnSpecIGSTData scrnSpecIGSTData;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "scrn_spec_cgst_id", referencedColumnName = "id")
//    private SanOrderScrnSpecCGSTData scrnSpecCGSTData;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "scrn_spec_sgst_id", referencedColumnName = "id")
//    private SanOrderScrnSpecSGSTData scrnSpecSGSTData;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "scrn_spec_cess_id", referencedColumnName = "id")
//    private SanOrderScrnSpecCESSData scrnSpecCESSData;
}
