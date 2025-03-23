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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GST_RFND_DECL_DET")
@SequenceGenerator(name = "rfnd_decldet_seq" , sequenceName = "GST_RFND_DECL_DET_SEQ" , allocationSize = 1)
public class Declarationdtls  extends CommonEntityForAll{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "rfnd_decldet_seq")
    private Long id;

    @Column(name = "dec_1")
    private Character declarationType1;
    
    @Column(name = "dec_2") 
    private Character declarationType2;

    @Column(name = "dec_3") 
    private Character declarationType3;

    @Column(name = "dec_4") 
    private Character declarationType4;

    @Column(name = "dec_5") 
    private Character declarationType5;

    @Column(name = "undertaking_1")
    private Character undertaking1;

    @Column(name = "undertaking_2")
    private Character undertaking2;

    @Column(name = "verification")
    private Character verification;
    
    @Column(name = "self_decl")
    private Character selfDeclaration;

    @Column(name = "sign_typ")
    private String signTyp;

    @Column(name = "name")
    private String name;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
