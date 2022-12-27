package com.kodlamaio.bootcampProject.business.concretes.applications;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.abstracts.blackList.BlackListService;
import com.kodlamaio.bootcampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.applications.ApplicationRepository;
import com.kodlamaio.bootcampProject.entities.applications.Application;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;
	private BlackListService blackListService;
	private BootcampService bootcampService;

	@Override
	public Result delete(int id) {
		chechIfApplicationExistsById(id);
		this.applicationRepository.deleteById(id);

		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		checkIfApplicantIdExists(createApplicationRequest.getApplicantId());
		// checkIfApplicationExistByIdNotDoes(createApplicationRequest.getApplicantId());
		blackListService.checkIfApplicantIdBlackListExist(createApplicationRequest.getApplicantId());
		checkIfBootcampExsist(createApplicationRequest.getBootcampId());
		Application application = this.modelMapperService.forRequest().map(createApplicationRequest, Application.class);
		this.applicationRepository.save(application);
		CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application,
				CreateApplicationResponse.class);

		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		checkIfApplicantIdExists(updateApplicationRequest.getApplicantId());
		chechIfApplicationExistsById(updateApplicationRequest.getId());
		checkIfApplicationExistByIdNotDoes(updateApplicationRequest.getId());
		checkIfBootcampExsist(updateApplicationRequest.getId());
		blackListService.checkIfApplicantIdBlackListExist(updateApplicationRequest.getApplicantId());
		Application application = this.modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		this.applicationRepository.save(application);
		UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Application> applications = this.applicationRepository.findAll();
		List<GetAllApplicationResponse> getAllApplicationResponses = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllApplicationResponse>>(getAllApplicationResponses);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		chechIfApplicationExistsById(id);
		Application application = this.applicationRepository.findById(id).get();
		GetApplicationResponse getApplicationResponse = this.modelMapperService.forResponse().map(application,
				GetApplicationResponse.class);

		return new SuccessDataResult<GetApplicationResponse>(getApplicationResponse);
	}

	private void chechIfApplicationExistsById(int id) {
		if (!this.applicationRepository.existsById(id)) {
			throw new BusinessException(Messages.ApplicationIdNotExsits);
		}

	}

	private void checkIfApplicationExistByIdNotDoes(int id) {
		var result = applicantService.getById(id);
		if (result == null) {
			throw new BusinessException(Messages.ApplicantNotExists);
		}

	}

//	private void checkIfBlackListExists(int id) {
//		var result = blackListService.getByApplicantId(id);
//		if (result != null) {
//			throw new BusinessException(Messages.InTheBlackList);
//		}
//	}

	private void checkIfBootcampExsist(int id) {
		var result = bootcampService.getById(id);
		if (result == null) {
			throw new BusinessException(Messages.BootcampNotExists);
		}
	}

	private void checkIfApplicantIdExists(int applicantId) {
		Application applicant = applicationRepository.findByApplicantId(applicantId);
		if (applicant != null) {
			throw new BusinessException(Messages.CheckIfApplicantIdExists);
		}
	}

}
