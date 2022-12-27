package kodlama.io.rentACar.business.concretes;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.constants.Messages;
import kodlama.io.rentACar.business.requests.create.CreateModelRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteModelRequest;
import kodlama.io.rentACar.business.requests.update.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.create.CreateModelResponse;
import kodlama.io.rentACar.business.responses.get.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.get.model.GetModelResponse;
import kodlama.io.rentACar.business.responses.update.UpdateModelResponse;
import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.mapping.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelMapperService modelMapperService;
	private ModelRepository modelRepository;
	private BrandService brandService;

	@Override
	public DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest) {
		checkIfBrandId(createModelRequest.getBrandId());
	//	checkIfModelName(createModelRequest.getBrandId(), createModelRequest.getModelName());
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);

		model.setId(0);
		this.modelRepository.save(model);
		CreateModelResponse createModelResponse = this.modelMapperService.forResponse().map(model,
				CreateModelResponse.class);
		return new SuccessDataResult<CreateModelResponse>(createModelResponse, Messages.ModelCreated);
	}

	@Override
	public Result delete(DeleteModelRequest deleteModelRequest) {
		checkIfModelId(deleteModelRequest.getId());
		Model model = this.modelMapperService.forRequest().map(deleteModelRequest, Model.class);
		this.modelRepository.delete(model);
		return new SuccessResult(Messages.ModelDeleted);
	}

	@Override
	public DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest) {
		checkIfModelId(updateModelRequest.getId());
	//	checkIfModelName(updateModelRequest.getBrandId(), updateModelRequest.getModelName());
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		UpdateModelResponse modelResponse = this.modelMapperService.forResponse().map(model, UpdateModelResponse.class);
		return new SuccessDataResult<UpdateModelResponse>(modelResponse, Messages.ModelUpdated);
	}

	@Override
	public DataResult<List<GetAllModelResponse>> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelResponse> allModelResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllModelResponse>>(allModelResponses, Messages.ModelListed);
	}

	@Override
	public DataResult<GetModelResponse> getByModelId(int modelId) {
		Model model = this.modelRepository.findById(modelId);
		GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(model, GetModelResponse.class);
		return new SuccessDataResult<GetModelResponse>(getModelResponse, Messages.ModelListed);
	}

	private void checkIfModelId(int id) { // girilen model id var mı?
		Model model = this.modelRepository.findById(id);
		if (model == null) {
			throw new BusinessException(Messages.ModelIdNotFound);
		}

	}

	private void checkIfBrandId(int brandId) { // Girilen marka id si varmı?
		if (brandService.getById(brandId).getData() == null) {
			throw new BusinessException(Messages.BrandIdNotFound);
		}
	}


	}


