package kodlamaio.com.rentACar.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.com.rentACar.business.abstracts.ModelService;
import kodlamaio.com.rentACar.business.requests.create.CreateModelRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteModelRequest;
import kodlamaio.com.rentACar.business.requests.update.UpdateModelRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetAllModelResponse;
import kodlamaio.com.rentACar.business.responses.get.model.GetModelResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateModelResponse;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;

	@PostMapping()
	public ResponseEntity<?> add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		DataResult<CreateModelResponse> result = this.modelService.add(createModelRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping()
	public ResponseEntity<?> delete(@RequestBody @Valid DeleteModelRequest deleteModelRequest) {
		Result result = this.modelService.delete(deleteModelRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping()
	public ResponseEntity<?> update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {
		DataResult<UpdateModelResponse> result = this.modelService.update(updateModelRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);

	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllModelResponse>> result = this.modelService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/{modelId}")
	public ResponseEntity<?> getByModelId(@PathVariable int modelId) {
		DataResult<GetModelResponse> result = this.modelService.getByModelId(modelId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
