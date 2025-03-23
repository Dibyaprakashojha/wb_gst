package com.uneecops.common.entity;

import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.uneecops.common.dto.RfdAppDataDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GST_RFND_ITEMS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Items extends CommonEntityForAll{	
	
	@Id
	@Column(name = "hash")
	private String hash;

	@Column(name = "item_name")
	private String itemName;

	@OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "rfd_app_data_id")
	private RfndApplicationData rfdAppData;

	// One-to-Many relationship with RfdNotice
//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//	private List<RfdNotice> rfdNotices;
	
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL,orphanRemoval = true)
    private RfdNoticeData rfdNoticeData;  // One-to-Many Mapping with RfdNoticeData

//    // One-to-Many Relation with Rfd PMT 03
//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//	private List<RfdPMT03> rfdPMT03;
	
    // One-to-One with RfdRejectedAmntData (Reversed)
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private RfdRejectedAmntData rfdRejectedAmntData;

//    //One-to-Many relationship with RfdReply
//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<RfdReply> rfdReply;
	
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  //  @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id")
    private RfdReplyData rfdReplyData;

//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//	private List<RfdPaymentAdv> rfdPaymentAdv;
	
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "rfd_pmt_adv_order_id") // Foreign key for Order Data
    private RfdPaymentAdvOrderData rfdPaymentAdvcOrderData;
    
//	=======================Map RfdSanctionOrderData related data with item =========================
	// One-to-One relationship with ScrnSpecDetSanctionOrderDataEntity
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "sdtls_id", referencedColumnName = "id")
//	private ScrnSpecDetSanctionOrdData scrnSpecDetSanctionOrderData;
	
	@OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "sanc_order_det_id", referencedColumnName = "id")
    private SanctionOrderDet sanctionOrderDet;

//	// One-to-Many relationship with CommonDocDetailsEntity
//	@OneToMany(mappedBy = "items", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<RfdSanOrdDataDocDet> commonDocDetails;
//
//	// One-to-One relationship with CommonTaxOfficerDetEntity
//	@OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
//	private RfdSanOrdTODet commonTaxOfficerDet;
//	======================================================================================================

	@Column(name = "ref_id")
	private String refId;

	@Column(name = "ref_dt")
	@Temporal(TemporalType.DATE)
	private Date refDt;

	@ManyToOne
	@JoinColumn(name = "case_data_id" ,  nullable = true)
	private RfdResponse rfdResponse;

//	@OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
////    @JoinColumn(name = "rfd_san_order_data_id", referencedColumnName = "id")
//	private RfdSanctionOrderData rfdSanOrderData;

}
