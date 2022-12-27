package com.kodlamaio.bootcampProject.entities.evaluations;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootcampProject.entities.applications.Application;
import com.kodlamaio.bootcampProject.entities.states.BootcampState;
import com.kodlamaio.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "bootcamps")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bootcamp {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "dateStart")
	private LocalDate dateStart;
	@Column(name = "dateEnd")
	private LocalDate dateEnd;

	@ManyToOne
	@JoinColumn(name = "instructorId")
	private Instructor instructor;

	@OneToMany(mappedBy = "bootcamp")
	private List<Application> applications;
	
	@ManyToOne
	@JoinColumn(name="bootcampStateId")
	private BootcampState bootcampState;
}
