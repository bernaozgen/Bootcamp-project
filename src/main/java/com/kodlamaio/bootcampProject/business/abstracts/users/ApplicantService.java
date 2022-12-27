package com.kodlamaio.bootcampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {
	Result delete(int id);

	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);

	DataResult<List<GetAllApplicantResponse>> getAll();

	DataResult<GetApplicantResponse> getById(int id);



}
