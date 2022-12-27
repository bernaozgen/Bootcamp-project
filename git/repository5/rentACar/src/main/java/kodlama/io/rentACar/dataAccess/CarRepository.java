package kodlamaio.com.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.com.rentACar.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	Car findById(int id);
    Car getByPlate(String plate);
}
