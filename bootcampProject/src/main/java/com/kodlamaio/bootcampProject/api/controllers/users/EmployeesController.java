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

import com.kodlamaio.bootcampProject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootcampProject.business.requests.users.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.users.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.users.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	private EmployeeService employeeService;

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.employeeService.delete(id);
	}

	@PostMapping("/add")
	public DataResult<CreateEmployeeResponse> add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateEmployeeResponse> update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest) {
		return this.employeeService.update(updateEmployeeRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		return this.employeeService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return this.employeeService.getById(id);
	}
}
