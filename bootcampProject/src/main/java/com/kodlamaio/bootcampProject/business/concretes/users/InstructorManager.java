package com.kodlamaio.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.users.ınstructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.users.instructors.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.InstructorRepository;
import com.kodlamaio.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfInstructorExistsById(id);
		this.instructorRepository.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest  createInstructorRequest) {
		checkIfInstructorExistsByNationalIdentity(createInstructorRequest.getNationalIdentity());
		Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		this.instructorRepository.save(instructor);
		CreateInstructorResponse response = this.modelMapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);

		return new SuccessDataResult<CreateInstructorResponse>(response, Messages.InstructorCreated);

	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getall() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> getAllInstructorResponses = instructors.stream().map(
				instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllInstructorResponse>>(getAllInstructorResponses);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		checkIfInstructorExistsById(updateInstructorRequest.getId());
		checkIfInstructorExistsByNationalIdentity(updateInstructorRequest.getNationalIdentity());
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		this.instructorRepository.save(instructor);

		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);

		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		checkIfInstructorExistsById(id);
		Instructor instructor = this.instructorRepository.findById(id).get();
		GetInstructorResponse getInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				GetInstructorResponse.class);

		return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse);
	}

	private void checkIfInstructorExistsByNationalIdentity(String nationaIdentity) {
		Instructor instructor = this.instructorRepository.findByNationalIdentity(nationaIdentity);
		if (instructor!=null) {
			System.out.println("girmedi");
			throw new BusinessException(Messages.InstructorException);
		}

	} 


	private void checkIfInstructorExistsById(int id) {
//		Instructor instructor=this.instructorRepository.findById(id).get();
		if(!this.instructorRepository.existsById(id)) {
			throw new BusinessException(Messages.InstructorExceptionId);
		}
		
		
	}
}
