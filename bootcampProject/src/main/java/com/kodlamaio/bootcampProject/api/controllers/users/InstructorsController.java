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

import com.kodlamaio.bootcampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/instructors")
@RestController
@AllArgsConstructor
public class InstructorsController {

	private InstructorService instructorService;

	@GetMapping("/getbyid/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id) {
		return this.instructorService.getById(id);

	}

	@GetMapping("/getall")
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		return this.instructorService.getall();
	}

	@PostMapping("/add")
	public DataResult<CreateInstructorResponse> add(
			@RequestBody @Valid CreateInstructorRequest createInstructorRequest) {
		return this.instructorService.add(createInstructorRequest);
	}

	@PutMapping("update")
	public DataResult<UpdateInstructorResponse> update(
			@RequestBody @Valid UpdateInstructorRequest updateInstructorRequest) {
		return this.instructorService.update(updateInstructorRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}

}
