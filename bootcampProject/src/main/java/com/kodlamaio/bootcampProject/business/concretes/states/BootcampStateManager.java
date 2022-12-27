package com.kodlamaio.bootcampProject.business.concretes.states;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.state.BootcampStateService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.states.CreateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.requests.states.UpdateBootcampStateRequest;
import com.kodlamaio.bootcampProject.business.responses.states.CreateBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.GetAllBootcampStateResponse;
import com.kodlamaio.bootcampProject.business.responses.states.UpdateBootcampStateResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.state.BootcampStateRepository;
import com.kodlamaio.bootcampProject.entities.evaluations.Bootcamp;
import com.kodlamaio.bootcampProject.entities.states.BootcampState;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BootcampStateManager implements BootcampStateService {
	private BootcampStateRepository bootcampStateRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest createBootcampStateRequest) {

		BootcampState bootcampState = this.modelMapperService.forRequest().map(createBootcampStateRequest,
				BootcampState.class);
		this.bootcampStateRepository.save(bootcampState);
		CreateBootcampStateResponse createBootcampStateResponse = this.modelMapperService.forResponse()
				.map(bootcampState, CreateBootcampStateResponse.class);
		return new SuccessDataResult<CreateBootcampStateResponse>(createBootcampStateResponse,
				Messages.BootcampStateCreated);

	}

	@Override
	public Result delete(int id) {
		this.bootcampStateRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampStateDeleted);
	}

	@Override
	public DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest) {
		checkIfBootcampStateExistById(updateBootcampStateRequest.getId());
		BootcampState bootcampState = this.modelMapperService.forRequest().map(updateBootcampStateRequest,
				BootcampState.class);
		this.bootcampStateRepository.save(bootcampState);
		UpdateBootcampStateResponse updateBootcampStateResponse = this.modelMapperService.forResponse()
				.map(bootcampState, UpdateBootcampStateResponse.class);
		return new SuccessDataResult<UpdateBootcampStateResponse>(updateBootcampStateResponse,
				Messages.BootcampStateCreated);

	}

	public DataResult<List<GetAllBootcampStateResponse>> getAll() {
		List<BootcampState> bootcampStates = this.bootcampStateRepository.findAll();
		List<GetAllBootcampStateResponse> stateResponses = bootcampStates.stream()
				.map(bootcampState -> this.modelMapperService.forResponse().map(bootcampState,
						GetAllBootcampStateResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllBootcampStateResponse>>(stateResponses);
	}

	private void checkIfBootcampStateExistById(int id) {
		BootcampState bootcampState = this.bootcampStateRepository.findById(id);
		if (bootcampState == null) {
			throw new BusinessException(Messages.BootcampStateNotExists);
		}
	}

}
