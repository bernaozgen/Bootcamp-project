package com.kodlamaio.bootcampProject.business.concretes.bootcamps;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.GetByNameResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.bootcamps.BootcampRepository;
import com.kodlamaio.bootcampProject.entities.evaluations.Bootcamp;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest) {

		checkIfStartDateIsItBigEndDate(bootcampRequest.getDatestart(), bootcampRequest.getDateEnd());
		checkIfInstructorExistsById(bootcampRequest.getInstructorId());
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);
		this.bootcampRepository.save(bootcamp);
		CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfBootcampExistById(id);
		this.bootcampRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = this.bootcampRepository.findAll();
		List<GetAllBootcampResponse> getAllBootcampResponses = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponse>>(getAllBootcampResponses);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExistById(id);
		Bootcamp bootcamp = this.bootcampRepository.findById(id);
		GetBootcampResponse getBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(getBootcampResponse);
	}

	@Override
	public DataResult<List<GetByNameResponse>> getByName(String name) {
		List<Bootcamp> bootcamps = this.bootcampRepository.getByName(name);
		List<GetByNameResponse> getByNameResponse = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetByNameResponse.class)).toList();

		return new SuccessDataResult<List<GetByNameResponse>>(getByNameResponse);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfBootcampExistById(updateBootcampRequest.getId());
		checkIfStartDateIsItBigEndDate(updateBootcampRequest.getDateStart(), updateBootcampRequest.getDateEnd());
		Bootcamp bootcamp = this.bootcampRepository.findById(updateBootcampRequest.getId());
		this.bootcampRepository.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse);
	}

	private void checkIfBootcampExistById(int id) {

		if (bootcampRepository.findById(id) == null) {

			throw new BusinessException(Messages.BootcampNotExists);
		}
	}

	private void checkIfInstructorExistsById(int id) {
		if (instructorService.getById(id) == null) {
			throw new BusinessException(Messages.InstructorExceptionId);
		}

	}

	private void checkIfStartDateIsItBigEndDate(LocalDate startDate, LocalDate endDate) {
		if (startDate.isAfter(endDate)) {
			throw new BusinessException("start date cannot be later than end date");
		}
	}

}
