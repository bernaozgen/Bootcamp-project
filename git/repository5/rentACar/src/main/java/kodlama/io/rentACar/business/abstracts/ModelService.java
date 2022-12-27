package kodlamaio.com.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.com.rentACar.business.requests.create.CreateModelRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteModelRequest;
import kodlamaio.com.rentACar.business.requests.update.UpdateModelRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetAllModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetModelResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateModelResponse;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;

public interface ModelService {

	DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest);

	Result delete(DeleteModelRequest deleteModelRequest);

	DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest);

	DataResult<List<GetAllModelResponse>> getAll();

	DataResult<GetModelResponse> getByModelId(int modelId);

}
