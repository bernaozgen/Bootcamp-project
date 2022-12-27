package com.kodlamaio.bootcampProject.business.requests.users.ınstructor;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
	@NotNull
	@Size(min=3)
	@NotEmpty(message = "First name is cannot be empty ")
	private String firstName;
	@NotNull
	@Size(min=3)
	@NotEmpty(message = "Last name is cannot be empty ")
	private String lastName;
	@NotNull
	@NotEmpty(message = "email is cannot be empty ")
	@Email(message = "email format is incorrect")
	private String email;
	@NotNull
	@NotEmpty(message = "password is cannot be empty")
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	@NotNull
	@Size(min = 11, max = 11, message = "national ıdentity must be 11 digits")
	private String nationalIdentity;
	@NotNull
	@NotEmpty(message = "Company name is cannot be empty")
	private String companyName;

}
