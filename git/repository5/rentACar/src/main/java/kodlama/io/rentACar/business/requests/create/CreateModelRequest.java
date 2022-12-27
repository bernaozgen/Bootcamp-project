package kodlamaio.com.rentACar.business.requests.create;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

	@NotNull
	private int brandId;
	@NotNull
	@NotEmpty
	private String modelName; 

}
