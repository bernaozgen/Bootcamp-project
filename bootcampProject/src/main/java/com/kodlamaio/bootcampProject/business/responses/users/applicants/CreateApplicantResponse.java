package com.kodlamaio.bootcampProject.business.responses.users.applicants;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {

	private int id;
	private String nationalIdentity;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String email;
	private String about;

}
