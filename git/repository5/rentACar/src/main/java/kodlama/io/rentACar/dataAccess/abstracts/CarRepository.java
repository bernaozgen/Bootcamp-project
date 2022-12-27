package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	Car findById(int id);
    Car getByPlate(String plate);
}
