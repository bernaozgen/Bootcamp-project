package com.kodlamaio.bootcampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
	@NotNull
	@Min(0)
	private int id;
	@NotNull
	@NotEmpty(message = "name is cannot be empty")
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateStart;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateEnd;
	@NotNull
	@Min(0)
	private int instructorId;
	@NotNull
	@Min(0)
	private int bootcampStateId;
}
