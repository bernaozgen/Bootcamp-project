package com.kodlamaio.bootcampProject.business.abstracts.state;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.states.CreateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.requests.states.UpdateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.responses.states.CreateBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.GetAllBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.UpdateBootcampStateResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BootcampStateService {
	Result delete(int id);

	DataResult<List<GetAllBootcampStateResponse>> getAll();

	DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest createBootcampStateRequest);

	DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest);
}
