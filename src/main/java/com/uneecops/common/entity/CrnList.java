//package com.uneecops.common.entity;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//@Entity
//@Getter
//@Setter
//@Table(name = "RFND_CRN_LIST")
//public class CrnList {
//
//    @Id
//    @Column(name = "CRN")
//    private String crn;
//
//    @Column(name = "UPDATE_TIME_STAMP")
//    private String updateTmstmp;
//
//    @Column(name = "APPROVAL_AUTHORITY")
//    private String approvAuth;
//
//    @Column(name = "CASE_TYPE")
//    private String casetyp;
//
//    @Column(name = "STATUS")
//    private String status;
//
//    @ManyToOne
//    @JoinColumn(name = "TIME_COUNT_ID", nullable = false)
//    private TimeCount timeCount; // Foreign key reference
//}
