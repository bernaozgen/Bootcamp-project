package com.kodlamaio.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.users.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.users.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.users.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.users.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.EmployeeRepository;
import com.kodlamaio.bootcampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfEmployeeExistsById(id);
		this.employeeRepository.deleteById(id);
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeExistsByNationalIdentity(createEmployeeRequest.getNationalIdentity());
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);

		return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeExistsByNationalIdentity(updateEmployeeRequest.getNationalIdentity());
		checkIfEmployeeExistsById(updateEmployeeRequest.getId());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);

		return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse, Messages.EmployeeUpdated);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {

		List<Employee> employees = this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(getAllEmployeeResponses);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		checkIfEmployeeExistsById(id);
		Employee employee = this.employeeRepository.findById(id).get();
		GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse);
	}

	private void checkIfEmployeeExistsByNationalIdentity(String nationalIdentity) {
		Employee employee = this.employeeRepository.findByNationalIdentity(nationalIdentity);
		if (employee != null) {
			throw new BusinessException(Messages.EmployeeException);
		}

	}

	private void checkIfEmployeeExistsById(int id) {
		if (!this.employeeRepository.existsById(id)) {
			throw new BusinessException(Messages.EmployeeExceptionId);
		}

	}

}
