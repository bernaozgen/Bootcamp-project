package com.kodlamaio.bootcampProject.business.abstracts.blackList;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackLists.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetAllBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackLists.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BlackListService {

	DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);

	Result delete(int id);

	DataResult<UpdateBlacklistResponse> update(UpdateBlackListRequest updateBlackListRequest);

	DataResult<List<GetAllBlackListResponse>> getAll();

	DataResult<GetBlackListResponse> getById(int id);

	DataResult<GetBlackListResponse> getByApplicantId(int applicantId);
	void checkIfApplicantIdBlackListExist(int id);

}
