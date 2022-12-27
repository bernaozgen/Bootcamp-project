package kodlamaio.com.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.com.rentACar.business.abstracts.CarService;
import kodlamaio.com.rentACar.business.constants.Messages;
import kodlamaio.com.rentACar.business.requests.create.CreateCarRequest;
import kodlamaio.com.rentACar.business.requests.delete.DeleteCarRequest;
import kodlamaio.com.rentACar.business.requests.update.UpdateCarRequest;
import kodlamaio.com.rentACar.business.responses.create.CreateCarResponse;
import kodlamaio.com.rentACar.business.responses.get.car.GetAllCarResponse;
import kodlamaio.com.rentACar.business.responses.get.car.GetCarResponse;
import kodlamaio.com.rentACar.business.responses.update.UpdateCarResponse;
import kodlamaio.com.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaio.com.rentACar.core.utilities.mapping.ModelMapperService;
import kodlamaio.com.rentACar.core.utilities.results.DataResult;
import kodlamaio.com.rentACar.core.utilities.results.Result;
import kodlamaio.com.rentACar.core.utilities.results.SuccessDataResult;
import kodlamaio.com.rentACar.core.utilities.results.SuccessResult;
import kodlamaio.com.rentACar.dataAccess.CarRepository;
import kodlamaio.com.rentACar.entities.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateCarResponse> add(CreateCarRequest createCarRequest) {
		checkIfCarPlateExist(createCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		CreateCarResponse carResponse = this.modelMapperService.forResponse().map(car, CreateCarResponse.class);

		return new SuccessDataResult<CreateCarResponse>(carResponse, Messages.CarCreated);
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		checkIfCarId(deleteCarRequest.getId());
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carRepository.delete(car);

		return new SuccessResult(Messages.CarDeleted);
	}

	@Override
	public DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest) {
		checkIfCarId(updateCarRequest.getId());
		checkIfCarPlateExist(updateCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		UpdateCarResponse updateCarResponse = this.modelMapperService.forResponse().map(car, UpdateCarResponse.class);
		return new SuccessDataResult<UpdateCarResponse>(updateCarResponse, Messages.CarUpdated);
	}

	@Override
	public DataResult<List<GetAllCarResponse>> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarResponse> allCarResponses = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCarResponse>>(allCarResponses, Messages.CarListed);
	}

	@Override
	public DataResult<GetCarResponse> getByCarId(int id) {
		checkIfCarId(id);
		Car car = this.carRepository.findById(id);
		GetCarResponse carResponse = this.modelMapperService.forResponse().map(car, GetCarResponse.class);

		return new SuccessDataResult<GetCarResponse>(carResponse, Messages.CarListed);
	}
	
	private void checkIfCarId(int id) {
		Car car=this.carRepository.findById(id);
		if(car==null) {
			throw new BusinessException(Messages.CarIdNotFound);
		}
	}
	
	private void checkIfCarPlateExist(String plate) {
		Car car=this.carRepository.getByPlate(plate);
		if(car!=null) {
			throw  new BusinessException(Messages.PlateExist);
		}
		
	}
	
	
	
	

}
