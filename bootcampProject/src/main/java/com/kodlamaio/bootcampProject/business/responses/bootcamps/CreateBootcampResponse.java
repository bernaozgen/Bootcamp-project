package com.kodlamaio.bootcampProject.business.responses.bootcamps;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
	private int id;
	private String name;
	private LocalDate datestart;
	private LocalDate dateEnd;
	private int bootcampStateId;
	private int instructorId;
}
