package com.kodlamaio.bootcampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.users.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.users.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.users.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface EmployeeService {

	Result delete(int id);

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);

	DataResult<List<GetAllEmployeeResponse>> getAll();

	DataResult<GetEmployeeResponse> getById(int id);

}
