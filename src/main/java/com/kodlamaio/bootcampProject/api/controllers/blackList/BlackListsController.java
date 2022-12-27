package com.kodlamaio.bootcampProject.api.controllers.blackList;

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

import com.kodlamaio.bootcampProject.business.abstracts.blackList.BlackListService;
import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackLists.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetAllBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlackListsController {
	
	private BlackListService blackListService;

	@PostMapping("/add")
	public DataResult<CreateBlackListResponse> add(@RequestBody @Valid CreateBlackListRequest createBlackListRequest) {
		return blackListService.add(createBlackListRequest);
	}

	@PutMapping("/update/{id}")
	public DataResult<UpdateBlacklistResponse> update(@RequestBody @Valid UpdateBlackListRequest updateBlackListRequest) {
		return blackListService.update(updateBlackListRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		return blackListService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id) {
		return blackListService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return blackListService.delete(id);
	}

}
