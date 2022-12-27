package com.kodlamaio.bootcampProject.business.responses.users.instructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String nationalIdentity;
	private String companyName;
}
