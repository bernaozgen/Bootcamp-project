package kodlama.io.rentACar.business.abstracts;

import java.util.List;



import kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteBrandReguest;
import kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface BrandService {

	DataResult<CreateBrandResponse> add(CreateBrandRequest brandRequest);

	Result delete(DeleteBrandReguest deleteBrandReguest);

	DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest);

	DataResult<GetBrandResponse> getById(int id);

	DataResult<List<GetAllBrandResponse>> getAll();
}
