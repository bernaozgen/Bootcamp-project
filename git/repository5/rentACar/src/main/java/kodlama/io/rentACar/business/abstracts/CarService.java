package kodlama.io.rentACar.business.abstracts;

import java.util.List;



import kodlama.io.rentACar.business.requests.create.CreateCarRequest;
import kodlama.io.rentACar.business.requests.delete.DeleteCarRequest;
import kodlama.io.rentACar.business.requests.update.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.create.CreateCarResponse;
import kodlama.io.rentACar.business.responses.get.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.get.car.GetCarResponse;
import kodlama.io.rentACar.business.responses.update.UpdateCarResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface CarService {
	DataResult<CreateCarResponse> add(CreateCarRequest createCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);

	DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest);

	DataResult<List<GetAllCarResponse>> getAll();

	DataResult<GetCarResponse> getByCarId(int id);

}
