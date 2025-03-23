package com.uneecops.common.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RfdResponseDto {

	@JsonProperty("casety_cd")
	private String casetyCd;

	@JsonProperty("status_cd")
	private String statusCd;

	@JsonProperty("dof")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date caseCreationDate;

	@JsonProperty("gstin")
	private String gstin;

	@JsonProperty("items")
	private List<ItemDto> items;

	@JsonProperty("crn")
	private String crn;
}
