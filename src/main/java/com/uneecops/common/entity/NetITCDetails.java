package com.uneecops.common.entity;

import java.math.BigDecimal;

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
@Table(name = "GST_RFND__APP_NETITCDET")
@SequenceGenerator(name = "netitc_det_seq", sequenceName = "NETITC_DET_SEQ", allocationSize = 1)
public class NetITCDetails  extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "netitc_det_seq")
    @Column(name = "net_itc_det_id")
    private Long netItcDetId;
	
//    //One-to-One with NetItcIGST
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "igrfclm_id") // Foreign key column
//    private NetItcIGST igrfclm;
    
    
    @Column(name = "netItc_igst_tax")
    private BigDecimal igstTax;
    

    //One-to-One with NetItcSGST
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sgrfclm_id")
//    private NetItcSGST sgrfclm;
    
    @Column(name = "netItc_sgst_tax")
    private BigDecimal sgstTax;

//    //One-to-One with NetItcCGST
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cgrfclm_id")
//    private NetItcCGST cgrfclm;
    
    @Column(name = "netItc_cgst_tax")
    private BigDecimal cgstTax;

//    //One-to-One with NetItcCESS
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "csrfclm_id")
//    private NetItcCESS csrfclm;
    
    
    @Column(name = "netItc_cess_tax")
    private BigDecimal cessTax;
    
    @OneToOne
    @JoinColumn(name = "statement_id", referencedColumnName = "statement_id")
    private Statement statement;
	
}
