package com.kodlamaio.bootcampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface InstructorService {

	Result delete(int id);

	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);

	DataResult<List<GetAllInstructorResponse>> getall();

	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);

	DataResult<GetInstructorResponse> getById(int id);


}

