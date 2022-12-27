package kodlamaio.com.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.com.rentACar.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	Brand findById(int id);

	Brand getByBrandName(String brandName);

}
