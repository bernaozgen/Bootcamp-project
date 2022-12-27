package com.kodlamaio.bootcampProject.entities.blackList;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kodlamaio.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "blackLists")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BlackList {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "reason")
	private String reason;

	@Column(name = "date")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "applicantId")
	private Applicant applicant;

}
