package kodlamaio.com.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.com.rentACar.business.requests.create.CreateBrandRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteBrandReguest;
import kodlamaio.com.rentACar.business.requests.update.UpdateBrandRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateBrandResponse;
import kodlamaio.com.rentACar.business.responses.get.brand.GetAllBrandResponse;
import kodlamaio.com.rentACar.business.responses.get.brand.GetBrandResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateBrandResponse;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;

public interface BrandService {

	DataResult<CreateBrandResponse> add(CreateBrandRequest brandRequest);

	Result delete(DeleteBrandReguest deleteBrandReguest);

	DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest);

	DataResult<GetBrandResponse> getById(int id);

	DataResult<List<GetAllBrandResponse>> getAll();
}
