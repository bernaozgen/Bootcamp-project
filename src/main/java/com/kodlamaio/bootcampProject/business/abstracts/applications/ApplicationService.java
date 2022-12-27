package com.kodlamaio.bootcampProject.business.abstracts.applications;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicationService {
	Result delete(int id);

	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);
	
	DataResult<List<GetAllApplicationResponse>> getAll();

	DataResult<GetApplicationResponse> getById(int id);
	

}
