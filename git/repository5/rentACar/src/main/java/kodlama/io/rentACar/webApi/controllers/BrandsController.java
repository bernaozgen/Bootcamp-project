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

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteBrandReguest;
import kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid CreateBrandRequest brandRequest) {
		DataResult<CreateBrandResponse> result = this.brandService.add(brandRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@RequestBody @Valid DeleteBrandReguest deleteBrandReguest) {
		Result result = this.brandService.delete(deleteBrandReguest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
		DataResult<UpdateBrandResponse> result = this.brandService.update(updateBrandRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable @Valid int id) {
		DataResult<GetBrandResponse> result = this.brandService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping()
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllBrandResponse>> result = this.brandService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
