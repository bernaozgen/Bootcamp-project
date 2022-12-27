package kodlamaio.com.rentACar.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandResponse {

	private int id;
	private String brandName;

}
