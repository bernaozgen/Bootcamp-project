package kodlamaio.com.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.com.rentACar.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	Model findById(int id);

	Model getByModelName(String modelName);
}
