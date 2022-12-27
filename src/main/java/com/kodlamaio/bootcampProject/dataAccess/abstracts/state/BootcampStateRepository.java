package com.kodlamaio.bootcampProject.dataAccess.abstracts.state;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.states.BootcampState;

public interface BootcampStateRepository extends JpaRepository<BootcampState, Integer> {
	BootcampState findById(int id);
}
