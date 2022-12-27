package kodlamaio.com.rentACar.business.responses.get.model;

import java.util.List;

import kodlamaio.com.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {
	private int brandId;
	private int id;
	private String modelName;
	private List<Car> cars;
}
