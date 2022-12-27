package com.kodlamaio.bootcampProject.business.abstracts.bootcamps;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetByNameResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BootcampService {
	Result delete(int id);

	DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest);

	DataResult<List<GetAllBootcampResponse>> getAll();

	DataResult<GetBootcampResponse> getById(int id);

	DataResult<List<GetByNameResponse>> getByName(String name);

	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);

}
