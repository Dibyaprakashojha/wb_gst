package com.uneecops.common.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "RFND_TIMESTAMP_TABLE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name = "time_count_seq", sequenceName = "RFND_TIMESTAMP_TABLE_SEQ", allocationSize = 1)
public class TimeCount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_count_seq")	
	@Column(name = "ID")
	private Long id;


    @Column(name = "START_TIME")
    private String  startTm;

    @Column(name = "END_TIME")
    private String  endTm;

    // One-to-Many relationship with DayCount
    @OneToMany(mappedBy = "timeCount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayCount> dayCounts;

    // One-to-Many relationship with CrnList
    @OneToMany(mappedBy = "timeCount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrnList> crnLists;
    
    
    
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updateDate;

}
