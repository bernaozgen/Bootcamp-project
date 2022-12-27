package kodlamaio.com.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.com.rentACar.business.abstracts.BrandService;
import kodlamaio.com.rentACar.business.abstracts.ModelService;
import kodlamaio.com.rentACar.business.constants.Messages;
import kodlamaio.com.rentACar.business.requests.create.CreateModelRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteModelRequest;
import kodlamaio.com.rentACar.business.requests.update.UpdateModelRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetAllModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetModelResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateModelResponse;
import kodlamaio.com.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaio.com.rentACar.core.utilities.mapping.ModelMapperService;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;
import kodlamaio.com.rentACar.core.utilities.results.SuccessDataResult;
import kodlamaio.com.rentACar.core.utilities.results.SuccessResult;
import kodlamaio.com.rentACar.dataAccess.ModelRepository;
import kodlamaio.com.rentACar.entities.Model;
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

//	private void checkIfModelName(int brandId, String modelName) { // ilgili markada ilgili modelname var mı?
//		Model model = this.modelRepository.getByModelName(modelName);
//		if (brandService.getById(brandId).getData().getModels().forEach(
//				modell->modelName=model.getModelName())==modelName) {
//			
//		}
//		if (model.getBrand().getId() == brandId) {
//			throw new BusinessException(Messages.ModelNameExist);
//
//		}
	}


