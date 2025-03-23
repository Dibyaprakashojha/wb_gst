package com.uneecops.common.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementSummaryDTO {

    @JsonProperty("ttlinvcamt")
    private BigDecimal totalInvoiceAmount;

    @JsonProperty("invccount")
    private String invoiceCount;
}
