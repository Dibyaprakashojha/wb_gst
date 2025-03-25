package com.uneecops.common.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RFND_DAY_COUNT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayCount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "day_count_seq")
    @SequenceGenerator(name = "day_count_seq", sequenceName = "RFND_DAY_COUNT_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "CASE_TYPE", nullable = false)
    private String casetyp;

    @Column(name = "CNT", nullable = false)
    private int cnt;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:HH:mm")
    @Column(name = "END_TIME", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "TIME_COUNT_ID", nullable = false)
    private TimeCount timeCount; // Foreign key reference
    
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updateDate;

}
