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
public class ReferenceClaimDto {

    @JsonProperty("igrfclm")
    private IgstRefClaimDetdto igstRefClaimDet;

    @JsonProperty("sgrfclm")
    private SgstRefClaimDetdto sgstRefClaimDet;

    @JsonProperty("csrfclm")
    private CessRefClaimDetdto cessRefClaimDet;

    @JsonProperty("cgrfclm")
    private CgstRefClaimDetdto cgstRefClaimDet;
}
