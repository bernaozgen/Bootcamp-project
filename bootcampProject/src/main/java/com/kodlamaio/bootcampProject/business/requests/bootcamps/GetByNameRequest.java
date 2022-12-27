package com.kodlamaio.bootcampProject.business.requests.bootcamps;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNameRequest {
	@NotEmpty(message = "name is cannot be empty")
	@Size(min = 3)
	private String name;
}
