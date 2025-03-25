package com.uneecops.common.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uneecops.common.entity.DayCount;

@Repository
public interface DayCountRepo extends JpaRepository<DayCount, Long> {

	// Using TRUNC() for Oracle database compatibility
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM RFND_DAY_COUNT WHERE TRUNC(CREATED_AT) = :dataDate", nativeQuery = true)
	boolean existsByCreatedAt(@Param("dataDate") LocalDate dataDate);

	@Query(value = "SELECT * FROM RFND_DAY_COUNT WHERE TRUNC(END_TIME) = :date", nativeQuery = true)
	List<DayCount> findByEndTimeDate(@Param("date") LocalDate date);

	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM RFND_DAY_COUNT WHERE TRUNC(END_TIME) = :date", nativeQuery = true)
	Integer existsByEndTimeDate(@Param("date") LocalDate date);

}
