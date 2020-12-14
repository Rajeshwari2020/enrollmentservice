package com.challenge.enrollmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.enrollmentservice.models.Enrollee;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolleeRepository extends  JpaRepository<Enrollee, Long> {
	 
}

