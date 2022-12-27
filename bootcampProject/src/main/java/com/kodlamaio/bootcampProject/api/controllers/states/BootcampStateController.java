package com.kodlamaio.bootcampProject.api.controllers.states;

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

import com.kodlamaio.bootcampProject.business.abstracts.state.BootcampStateService;
import com.kodlamaio.bootcampProject.business.requests.states.CreateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.requests.states.UpdateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.responses.states.CreateBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.GetAllBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.UpdateBootcampStateResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/bootcampStates")
@RestController
@AllArgsConstructor
public class BootcampStateController {
	private BootcampStateService bootcampStateService;

	@PostMapping("/add")
	public DataResult<CreateBootcampStateResponse> add(@RequestBody @Valid CreateBootcampStateRequest createBootcampStateRequest) {
		return this.bootcampStateService.add(createBootcampStateRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateBootcampStateResponse> update(@RequestBody @Valid UpdateBootcampStateRequest updateBootcampStateRequest) {
		return this.bootcampStateService.update(updateBootcampStateRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@PathVariable int id) {
		return this.bootcampStateService.delete(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllBootcampStateResponse>> getAll() {
		return this.bootcampStateService.getAll();
	}

}
