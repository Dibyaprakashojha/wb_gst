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
@Table(name = "GST_RFND_APP_NETITCBAL")
@SequenceGenerator(name = "net_itc_bal_seq", sequenceName = "NET_ITC_BAL_SEQ", allocationSize = 1)
public class NetITCBal  extends CommonEntityForAll{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "net_itc_bal_seq")
	@Column(name = "net_itc_bal_id")
	private Long netItcBalId;
	@Column(name = "sum_of_icsgst")
	private BigDecimal sumOfICSGST;

	@Column(name = "cess")
	private BigDecimal cess;
	
    @OneToOne
    @JoinColumn(name = "statement_id", referencedColumnName = "statement_id")
    private Statement statement;
	
	
}
