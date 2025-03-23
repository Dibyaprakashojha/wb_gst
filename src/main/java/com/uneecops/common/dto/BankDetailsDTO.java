package com.uneecops.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankDetailsDTO {

    @JsonProperty("acctno")
    private String accountNumber;  

    @JsonProperty("bnkadd")
    private String branchAddress;  

    @JsonProperty("nam")
    private String bankName;  

    @JsonProperty("ifsc")
    private String ifsc;  

    @JsonProperty("acctype")
    private String accountType;  

    @JsonProperty("refid")
    private String referenceNumber; 

    @JsonProperty("typoth")
    private String accountTypeOther;  

    @JsonProperty("original")
    private String original;  

    @JsonProperty("startdt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date startDate; 

    @JsonProperty("enddt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date endDate; 
}
