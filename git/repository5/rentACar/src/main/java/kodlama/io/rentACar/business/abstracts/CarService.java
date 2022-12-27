package kodlamaio.com.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.com.rentACar.business.requests.create.CreateCarRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteCarRequest;
import kodlamaio.com.rentACar.business.requests.update.UpdateCarRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateCarResponse;
import kodlamaio.com.rentACar.business.responses.get.car.GetAllCarResponse;
import kodlamaio.com.rentACar.business.responses.get.car.GetCarResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateCarResponse;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;

public interface CarService {
	DataResult<CreateCarResponse> add(CreateCarRequest createCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);

	DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest);

	DataResult<List<GetAllCarResponse>> getAll();

	DataResult<GetCarResponse> getByCarId(int id);

}
