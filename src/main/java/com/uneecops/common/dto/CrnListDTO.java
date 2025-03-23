package com.uneecops.common.dto;

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
public class CrnListDTO {

    @JsonProperty("crn")
    private String crn;  // CRN identifier
    
    @JsonProperty("updateTmstmp")
    private String updateTmstmp;  // Timestamp of update
    
    @JsonProperty("approvAuth")
    private String approvAuth;  // Approval authority (CENTER or STATE)
    
    @JsonProperty("casetyp")
    private String casetyp;  // Case type (RFUND)
    
    @JsonProperty("status")
    private String status;  // Current status (RSP, RSA, etc.)

}
