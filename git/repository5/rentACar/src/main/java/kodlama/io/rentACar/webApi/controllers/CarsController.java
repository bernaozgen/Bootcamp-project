package kodlama.io.rentACar.webApi.controllers;

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

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.create.CreateCarRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteCarRequest;
import kodlama.io.rentACar.business.requests.update.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.create.CreateCarResponse;
import kodlama.io.rentACar.business.responses.get.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.get.car.GetCarResponse;
import kodlama.io.rentACar.business.responses.update.UpdateCarResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RequestMapping("/api/cars")
@RestController
@AllArgsConstructor
public class CarsController {
	private CarService carService;

	@PostMapping()
	public ResponseEntity<?> add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		DataResult<CreateCarResponse> result = this.carService.add(createCarRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping()
	public ResponseEntity<?> delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest) {
		Result result = this.carService.delete(deleteCarRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		DataResult<UpdateCarResponse> result = this.carService.update(updateCarRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllCarResponse>> result = this.carService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getByCarId(@PathVariable @Valid int id) {
		DataResult<GetCarResponse> result = this.carService.getByCarId(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);

		}
		return ResponseEntity.badRequest().body(result);
	}

}
