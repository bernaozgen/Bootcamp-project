package com.kodlamaio.bootcampProject.api.controllers.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/applicants")
@RestController
@AllArgsConstructor
public class ApplicantsController {
	private ApplicantService applicantService;

	@PostMapping("/add")
	public DataResult<CreateApplicantResponse> add(@RequestBody @Valid CreateApplicantRequest createApplicantRequest) {
		return this.applicantService.add(createApplicantRequest);
	}

	@GetMapping("/getbyid/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return this.applicantService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		return this.applicantService.getAll();
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicantService.delete(id);
	}

	@PutMapping("/update")
	public DataResult<UpdateApplicantResponse> update(@RequestBody @Valid UpdateApplicantRequest updateApplicantRequest) {
		return this.applicantService.update(updateApplicantRequest);
	}

}
