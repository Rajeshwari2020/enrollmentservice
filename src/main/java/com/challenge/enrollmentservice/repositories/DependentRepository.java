package com.challenge.enrollmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.enrollmentservice.models.DependentEnrollee;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository  extends JpaRepository<DependentEnrollee, Long>{

}