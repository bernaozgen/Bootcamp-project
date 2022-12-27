package com.kodlamaio.bootcampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
//	boolean existsByNationaIdentity(String nationalIdentity);
	Applicant findByNationalIdentity(String nationalIdentity);
	
}
