package com.uneecops.common.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonStatementRefundClaim extends CommonEntityForAll{
	
	@Column(name = "intrest")
	private BigDecimal intrest;
	
	@Column(name = "others")
	private BigDecimal others;
	
	@Column(name = "fee")
	private BigDecimal fee;
	
	@Column(name = "penalty")
	private BigDecimal penalty;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	@Column(name = "Total")
	private BigDecimal tot;
}
