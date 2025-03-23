//package com.uneecops.common.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.uneecops.common.entity.TimeCount;
//
//@Repository
//public interface TimeStampRepo extends JpaRepository<TimeCount, Long> {
//
//	@Query(value = "SELECT MAX(end_time) FROM RFND_TIMESTAMP_TABLE WHERE end_time IS NOT NULL", nativeQuery = true)
//	String findMaxEndTime();
//	
//
//}
