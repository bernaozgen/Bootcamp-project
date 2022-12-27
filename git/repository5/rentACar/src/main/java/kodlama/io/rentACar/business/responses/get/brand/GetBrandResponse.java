package kodlama.io.rentACar.business.responses.get.brand;

import java.util.Collection;

import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandResponse {
	private int id;
	private String brandName;
	private Collection<Model> models;

}
