package com.kodlamaio.bootcampProject.business.requests.users.employee;

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
public class CreateEmployeeRequest {
	@NotNull
	@Size(min = 11, max = 11, message = "national ıdentity must be 11 digits")
	@NotEmpty(message = "National Identity is cannot be empty")
	private String nationalIdentity;
	@NotNull
	@Size(min = 3)
	@NotEmpty(message = "FirstName cannot be empty")
	private String firstName;
	@NotNull
	@Size(min = 3)
	@NotEmpty(message = "LastName cannot be empty")
	private String lastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	@NotNull
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "email format is incorrect")
	private String email;
	@NotNull
	@NotEmpty(message = "password cannot be empty")
	private String password;
	@NotNull
	@NotEmpty(message = "position cannot be empty")
	private String position;

}
