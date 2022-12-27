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
public class UpdateBlackListRequest {
	@Min(0)
	@NotNull
	private int id;
	@NotNull
	@Min(0)
	private int ApplicantId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	@NotNull
	@NotEmpty(message = "Reason is cannot be empty")
	private String reason;
}
