package com.kodlamaio.bootcampProject.business.responses.blackLists;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListResponse {
    private int id;
	private int ApplicantId;
	private LocalDate date;
	private String reason;
}
