package com.uneecops.common.entity;

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
public class CommonSupportDocDet extends CommonEntityForAll{

	@Column(name = "docName")
	private String docName;
	
	@Column(name = "doc_id")
	private String docid;
	
	@Column(name = "TypeCode")
	private String docTypeCode;
	
	@Column(name = "doc_title")
	private String docTtl;
	
	@Column(name = "content_Type")
	private String docContentType;
	
	@Column(name = "hash")
	private String hash;
}
