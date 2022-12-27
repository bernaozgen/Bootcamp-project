package com.kodlamaio.bootcampProject.business.responses.states;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampStateResponse {
	private int id;
	private String name;
}
