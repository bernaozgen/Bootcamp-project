package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.create.CreateModelRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteModelRequest;
import kodlama.io.rentACar.business.requests.update.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.create.CreateModelResponse;
import kodlama.io.rentACar.business.responses.get.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.get.model.GetModelResponse;
import kodlama.io.rentACar.business.responses.update.UpdateModelResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface ModelService {

	DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest);

	Result delete(DeleteModelRequest deleteModelRequest);

	DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest);

	DataResult<List<GetAllModelResponse>> getAll();

	DataResult<GetModelResponse> getByModelId(int modelId);

}
