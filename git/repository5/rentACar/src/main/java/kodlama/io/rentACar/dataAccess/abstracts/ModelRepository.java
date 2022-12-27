package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	Model findById(int id);

	Model getByModelName(String modelName);
}
