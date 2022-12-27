package com.kodlamaio.bootcampProject.entities.applications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.kodlamaio.bootcampProject.entities.evaluations.Bootcamp;
import com.kodlamaio.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "aplications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "state")
	private int state;

	@ManyToOne
	@JoinColumn(name = "applicantId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Applicant applicant;

	@ManyToOne
	@JoinColumn(name = "bootcampId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Bootcamp bootcamp;

}
