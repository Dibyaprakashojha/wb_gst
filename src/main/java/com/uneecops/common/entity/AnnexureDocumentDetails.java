package com.uneecops.common.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "GST_RFND_ANNEXURE_DOCDET")
@SequenceGenerator(name = "annex_doc_det_id_seq", sequenceName = "ANNEX_DOC_DET_ID_SEQ", allocationSize = 1)
public class AnnexureDocumentDetails extends CommonSupportDocDet{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="annex_doc_det_id_seq" )
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_data_id", nullable = false) // Foreign Key
    private RfndApplicationData rfndApplicationData;
}
