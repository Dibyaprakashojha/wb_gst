package com.uneecops.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "GST_RFND_APPDATA_ZEROTO")
@SequenceGenerator(name = "zerorated_to_seq", sequenceName = "ZERORATED_TURNOVER_SEQ", allocationSize = 1)
public class ZeroratedTurnOver extends CommonTaxDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zerorated_to_seq")
    @Column(name = "ZeroTo_id", nullable = false)
    private Long id;
}
