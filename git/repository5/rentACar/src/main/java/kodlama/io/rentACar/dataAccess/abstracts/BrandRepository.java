package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	Brand findById(int id);

	Brand getByBrandName(String brandName);

}
