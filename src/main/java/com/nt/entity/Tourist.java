package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "TID_SEQ", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer tid;

	@Column(length = 20)
	private String tname;

	@Column(length = 20)

	private String taddress;

	@Column(length = 20)

	private String packageType;

	private Double budget;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

        System.outprintln("hi hello");
}
