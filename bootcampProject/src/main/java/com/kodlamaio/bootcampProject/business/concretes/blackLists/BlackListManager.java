package com.kodlamaio.bootcampProject.business.concretes.blackLists;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.blackList.BlackListService;
import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackLists.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetAllBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.blackList.BlackListRepository;
import com.kodlamaio.bootcampProject.entities.blackList.BlackList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {
	private BlackListRepository blackListRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		checkIfApplicantExistById(createBlackListRequest.getApplicantId());
		BlackList blackList = this.modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
		this.blackListRepository.save(blackList);
		CreateBlackListResponse createBlackListResponse = this.modelMapperService.forResponse().map(blackList,
				CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse, Messages.BlackListCreated);

	}

	@Override
	public Result delete(int id) {
		checkIfBlackListExistById(id);
		this.blackListRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfApplicantExistById(updateBlackListRequest.getApplicantId());
		checkIfBlackListExistById(updateBlackListRequest.getId());
		BlackList blackList = this.modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
		this.blackListRepository.save(blackList);
		UpdateBlacklistResponse updateBlacklistResponse = this.modelMapperService.forResponse().map(blackList,
				UpdateBlacklistResponse.class);

		return new SuccessDataResult<UpdateBlacklistResponse>(updateBlacklistResponse, Messages.BlackListUpdated);
	}

	@Override
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		List<BlackList> blackLists = this.blackListRepository.findAll();
		List<GetAllBlackListResponse> allBlackListResponses = blackLists.stream()
				.map(blackList -> this.modelMapperService.forResponse().map(blackList, GetAllBlackListResponse.class))
				.toList();

		return new SuccessDataResult<List<GetAllBlackListResponse>>(allBlackListResponses);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistById(id);
		BlackList blackList = this.blackListRepository.findById(id);
		GetBlackListResponse getBlackListResponse = this.modelMapperService.forResponse().map(blackList,
				GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(getBlackListResponse);
	}

	@Override
	public DataResult<GetBlackListResponse> getByApplicantId(int applicantId) {
		BlackList blackList = blackListRepository.getByApplicantId(applicantId);
		GetBlackListResponse getBlackListResponse = this.modelMapperService.forResponse().map(blackList,
				GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(getBlackListResponse);
	}

	@Override
	public void checkIfApplicantIdBlackListExist(int id) {
		BlackList blackList = blackListRepository.getByApplicantId(id);
		if(blackList!=null) {
			throw new BusinessException("Applicant in blackList");
		}
	}

	private void checkIfBlackListExistById(int id) {

		if (this.blackListRepository.findById(id) == null) {
			throw new BusinessException(Messages.BlacklistNotExists);
		}
	}

	private void checkIfApplicantExistById(int applicantId) {
		var result = applicantService.getById(applicantId);
		if (result != null) {
			throw new BusinessException(Messages.BlackListNotExists);
		}
	}

}
