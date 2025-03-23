package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "GST_RFND_REPLY_DATA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "rfd_reply_data_seq", sequenceName = "RFD_REPLY_DATA_SEQ", allocationSize = 1)
public class RfdReplyData extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfd_reply_data_seq")
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "reply_dt")
    @Temporal(TemporalType.DATE)
    private Date replyDate;

    @Column(name = "scn_id")
    private String scnId;

    @Column(name = "scn_date")
    @Temporal(TemporalType.DATE)
    private Date scnDate;

    //One-to-Many: Main Documents
    @OneToMany(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RepmainDoc> maindocs;

    //One-to-Many: Supporting Documents
    @OneToMany(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RepSuppDoc> suppdocs;

    //One-to-One: Declaration Details
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "declaration_details_id", referencedColumnName = "id")
    private ReplDataDeclarationDet declarationDetails;

    @Column(name = "type_of_reply")
    private String typeOfRep;

    //One-to-One: Personal Hearing
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "personal_hearing_id", referencedColumnName = "id")
    private RfdRepDataPersonalHiringdet prsnlhrng;

    //One-to-One: Reply Extension Request
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "reply_extn_req_id", referencedColumnName = "id")
    private RedReplDataRplyextnreq rplyextnreq;

    //One-to-One: Undertaking Amount Details
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "undertaking_amt_dtl_id", referencedColumnName = "id")
//    private UndertakingAmtDetails undertakingAmtDtl;
    
    // One-to-One Mapping for Ledger Recredit Amounts
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "ledger_recredit_cess_id", referencedColumnName = "id")
    private LedgerRecreditamountcess ledgerRecreditamountcess;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "ledger_recredit_cgst_id", referencedColumnName = "id")
    private LedgerRecreditamountCGST ledgerRecreditamountCGST;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "ledger_recredit_igst_id", referencedColumnName = "id")
    private LedgerRecreditamtIGST ledgerRecreditamtIGST;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "ledger_recredit_sgst_id", referencedColumnName = "id")
    private LedgerRecreditamtSGST ledgerRecreditamtSGST;

    // One-to-One Mapping for Inadmissible Amounts
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "inadmissible_igst_id", referencedColumnName = "id")
    private InadmissibleAmounIGST amounIGST;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "inadmissible_sgst_id", referencedColumnName = "id")
    private InadmissibleAmounSGST amounSGST;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "inadmissible_cess_id", referencedColumnName = "id")
    private InadmissibleAmountcess amountcess;

    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "inadmissible_cgst_id", referencedColumnName = "id")
    private InadmissibleAmountCGST amountCGST;

    //One-to-One: Reply to Change Bank Account
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
 //   @JoinColumn(name = "reply_change_bank_acc_id", referencedColumnName = "id")
    private Replychangebankaccount repchangebankaccount;

    //One-to-One: SCN Reply
    @OneToOne(mappedBy = "rfdReplyData", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JoinColumn(name = "scn_reply_id", referencedColumnName = "id")
    private ScnReply scnReply;
    
    @Column(name = "undertaking_nil")
    private String undertakingNil;
   
	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Items item; // Now directly linked to Item

}

