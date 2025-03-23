package com.uneecops.common.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "GST_RFND_APP_SUPPLIERINFO")
@SequenceGenerator(name = "supplier_seq", sequenceName = "SUPPLIER_INFORMATION_SEQ", allocationSize = 1)
public class SupplierInformation extends CommonEntityForAll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @Column(name = "supplier_id")
    private Long supplierId;

	@Column(name = "gstin", length = 15, nullable = false)
	private String gstin;

    @OneToMany(mappedBy = "supplierInformation" , cascade= CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
 //   @JoinColumn(name = "supplier_id") // This will be a foreign key in InvoiceDetails
    private List<InvoiceDetails> invoiceDtls;
    
    @OneToOne
    @JoinColumn(name = "rfnd_application_id")
    private RfndApplicationData rfndApplicationData;
}
