package com.kodlamaio.bootcampProject.api.controllers.applications;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
	private ApplicationService applicationService;

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return applicationService.delete(id);
	}

	@PostMapping("/add")
	public DataResult<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest createApplicationRequest) {
		return this.applicationService.add(createApplicationRequest);
	}
	
	@PutMapping("/update/{id}")
	public DataResult<UpdateApplicationResponse> update(
			@RequestBody UpdateApplicationRequest updateApplicationRequest) {
		return this.applicationService.update(updateApplicationRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		return this.applicationService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return this.applicationService.getById(id);
	}

}
