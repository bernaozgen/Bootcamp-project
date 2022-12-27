package com.kodlamaio.bootcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootcampProject.entities.applications.Application;
import com.kodlamaio.bootcampProject.entities.blackList.BlackList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {

	@Column(name = "about")
	private String about;

	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;
	
	@OneToMany(mappedBy="applicant")
	private List<BlackList>blackLists;
}
