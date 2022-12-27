package com.kodlamaio.bootcampProject.business.responses.blackLists;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlacklistResponse {
	private int id;
	private int ApplicantId;
	private LocalDate date;
	private String reason;
}
