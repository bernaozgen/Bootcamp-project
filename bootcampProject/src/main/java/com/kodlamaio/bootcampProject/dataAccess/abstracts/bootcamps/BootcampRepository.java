package com.kodlamaio.bootcampProject.dataAccess.abstracts.bootcamps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.evaluations.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer>{
	List<Bootcamp>  getByName(String name);
	Bootcamp findById(int id);

}
