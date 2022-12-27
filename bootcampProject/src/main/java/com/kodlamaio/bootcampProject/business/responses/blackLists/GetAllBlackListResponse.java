package com.kodlamaio.bootcampProject.business.responses.blackLists;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBlackListResponse {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate date;
	private String reason;

}
