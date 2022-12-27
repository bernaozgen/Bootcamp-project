package com.kodlamaio.bootcampProject.business.requests.applications;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateApplicationRequest {
	@NotNull
	@Min(0)
	private int applicantId;
	@NotNull
	@Min(0)
	private int bootcampId;
	@NotNull
	private int state;

}
