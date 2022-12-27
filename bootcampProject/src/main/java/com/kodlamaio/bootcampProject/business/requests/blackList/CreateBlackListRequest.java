package com.kodlamaio.bootcampProject.business.requests.blackList;

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
public class CreateBlackListRequest {
	@NotNull
	@Min(0)
	private int ApplicantId;
	@NotNull
	@NotEmpty(message = "First name is cannot be empty ")
	private String reason;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
}
