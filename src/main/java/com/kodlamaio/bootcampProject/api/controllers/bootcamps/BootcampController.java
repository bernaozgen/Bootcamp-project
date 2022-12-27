package com.kodlamaio.bootcampProject.api.controllers.bootcamps;

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

import com.kodlamaio.bootcampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetByNameResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampController {
	private BootcampService bootcampService;

	@PostMapping("/add")
	public DataResult<CreateBootcampResponse> add(@RequestBody @Valid CreateBootcampRequest bootcampRequest) {
		return bootcampService.add(bootcampRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return bootcampService.delete(id);
	}

	@GetMapping
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		return bootcampService.getAll();
	}

	@GetMapping("getbyid/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
		return bootcampService.getById(id);
	}

	@GetMapping("/getbyname/getbyname")
	public DataResult<List<GetByNameResponse>> getByName(String name) {
		return bootcampService.getByName(name);
	}

	@PutMapping("/update/{id}")
	public DataResult<UpdateBootcampResponse> update(@RequestBody @Valid UpdateBootcampRequest updateBootcampRequest) {
		return this.bootcampService.update(updateBootcampRequest);
	}
}
