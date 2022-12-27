package com.kodlamaio.bootcampProject.dataAccess.abstracts.blackList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.blackList.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
	BlackList getByApplicantId(int applicantId);
	BlackList findById(int id);
}
