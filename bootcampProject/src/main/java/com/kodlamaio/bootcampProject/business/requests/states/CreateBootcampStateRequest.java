package com.kodlamaio.bootcampProject.business.requests.states;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampStateRequest {
	@NotNull
	@NotEmpty(message = "name is cannot be empty")
	private String name;
}
