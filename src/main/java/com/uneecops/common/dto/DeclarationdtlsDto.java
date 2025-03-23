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
public class DeclarationdtlsDto {

	@JsonProperty("dec_1")
	private Character declarationType1;
	
	@JsonProperty("dec_2")
	private Character declarationType2;
	
	@JsonProperty("dec_3")
	private Character declarationType3;
	
	@JsonProperty("dec_4")
	private Character declarationType4;
	
	@JsonProperty("dec_5")
	private Character declarationType5;
	
	@JsonProperty("undertaking_1")
	private Character undertaking1;
	
	@JsonProperty("undertaking_2")
	private Character undertaking2;
	
	@JsonProperty("verification")
	private Character verification;
	
	@JsonProperty("self_decl")
	private Character selfDeclaration;
	
	@JsonProperty("sign_typ")
	private String signType;
	
	@JsonProperty("name")
	private String name;
}
