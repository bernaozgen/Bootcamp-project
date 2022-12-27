package com.kodlamaio.bootcampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationResponse {
	private int id;
	private String applicantFirstName;
	private String applicantLastName;
	private String bootcampName;
	private int state;
}
