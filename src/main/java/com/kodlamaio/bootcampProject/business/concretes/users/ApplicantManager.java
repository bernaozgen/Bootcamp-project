package com.kodlamaio.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.users.applicants.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.ApplicantRepository;
import com.kodlamaio.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		chechByApplicantExistsById(id);
		this.applicantRepository.deleteById(id);

		return new SuccessResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		checkByApplicantExistsByNationalIdentity(createApplicantRequest.getNationalIdentity());
		Applicant applicant = this.modelMapperService.forResponse().map(createApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse applicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(applicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		checkByApplicantExistsByNationalIdentity(updateApplicantRequest.getNationalIdentity());
		chechByApplicantExistsById(updateApplicantRequest.getId());
		Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);

		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.ApplicantUpdated);
	}

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantResponse> allApplicantResponses = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(allApplicantResponses);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		chechByApplicantExistsById(id);
		Applicant applicant = this.applicantRepository.findById(id).get();
		GetApplicantResponse getApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				GetApplicantResponse.class);

		return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse);
	}

	
	private  void checkByApplicantExistsByNationalIdentity(String nationalIdentity) {
		
		Applicant applicant =this.applicantRepository.findByNationalIdentity(nationalIdentity);
		if (applicant!=null) {
			throw new BusinessException(Messages.ApplicantException);
		}

	}

	
	private  void chechByApplicantExistsById(int id) {
		if (!this.applicantRepository.existsById(id)) {
			throw new BusinessException(Messages.ApplicantIdNotExist);
		}
	}
	

}
