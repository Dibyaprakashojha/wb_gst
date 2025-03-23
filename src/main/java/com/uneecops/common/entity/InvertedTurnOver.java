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
//@Table(name = "GST_RFND_APPDATA_INVERTEDTO")
@SequenceGenerator(name = "inverted_turnover_seq", sequenceName = "INVERTED_TURNOVER_SEQ", allocationSize = 1)
public class InvertedTurnOver extends CommonTaxDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inverted_turnover_seq")
    @Column(name = "InvertedTo_id", nullable = false)
    private Long id;
}
