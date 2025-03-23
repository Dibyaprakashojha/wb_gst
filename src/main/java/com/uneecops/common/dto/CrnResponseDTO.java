package com.uneecops.common.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrnResponseDTO {

    @JsonProperty("crncnt")
    private int crncnt;  // Count of CRNs

    @JsonProperty("crnlist")
    private List<CrnListDTO> crnlist;  // List of CRN details
}

