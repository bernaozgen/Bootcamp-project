package com.kodlamaio.bootcampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
	@NotNull
	@NotEmpty(message="Name is cannot be empty")
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate datestart;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateEnd;
    @NotNull
	private int bootcampStateId;
    @NotNull
	private int instructorId;
}
