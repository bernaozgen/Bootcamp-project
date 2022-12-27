package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.constants.Messages;
import kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteBrandReguest;
import kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.mapping.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateBrandResponse> add(CreateBrandRequest brandRequest) {
		checkIfBrandName(brandRequest.getBrandName());
		Brand brand = this.modelMapperService.forRequest().map(brandRequest, Brand.class);
		this.brandRepository.save(brand);

		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
				CreateBrandResponse.class);
		return new SuccessDataResult<CreateBrandResponse>(createBrandResponse, Messages.BrandCreated);
	}

	@Override
	public Result delete(DeleteBrandReguest deleteBrandReguest) {
		checkIfBrandId(deleteBrandReguest.getId());
		Brand brand = this.modelMapperService.forRequest().map(deleteBrandReguest, Brand.class);
		brandRepository.delete(brand);
		return new SuccessResult(Messages.BrandDeleted);

	}

	@Override
	public DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest) {
		checkIfBrandId(updateBrandRequest.getId());
		checkIfBrandName(updateBrandRequest.getBrandName());
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand,
				UpdateBrandResponse.class);

		return new SuccessDataResult<UpdateBrandResponse>(updateBrandResponse, Messages.BrandUpdated);
	}

	@Override
	public DataResult<GetBrandResponse> getById(int id) {
		checkIfBrandId(id);
		Brand brand = this.brandRepository.findById(id);
		GetBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);
		return new SuccessDataResult<GetBrandResponse>(brandResponse, Messages.BrandListed);
	}

	@Override
	public DataResult<List<GetAllBrandResponse>> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandResponse> allBrandResponses = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllBrandResponse>>(allBrandResponses, Messages.BrandListed);
	}

	private void checkIfBrandId(int brandId) {
		Brand brand = this.brandRepository.findById(brandId);
		if (brand == null) {
			throw new BusinessException(Messages.BrandIdNotFound);
		}
	}

	private void checkIfBrandName(String brandName) {
		Brand brand = this.brandRepository.getByBrandName(brandName);
		if (brand != null) {
			throw new BusinessException(Messages.BrandNameExists); 
		}
	}

}
