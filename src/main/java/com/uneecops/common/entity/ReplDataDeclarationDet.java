package com.uneecops.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GST_RFD_REPLDATA_DECL_DET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "repl_data_decl_seq", sequenceName = "REPL_DATA_DECL_SEQ", allocationSize = 1)
public class ReplDataDeclarationDet extends CommonEntityForAll{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repl_data_decl_seq")
    private Long id;

    @Column(name = "verification", nullable = false)
    private Character verification;

    @Column(name = "sign_type", nullable = false)
    private String signtype;

    @Column(name = "signatory_name", nullable = false)
    private String signatoryname;
    
    @OneToOne
    @JoinColumn(name = "rfd_reply_data_id", referencedColumnName = "id", nullable = false)
    private RfdReplyData rfdReplyData;
}
