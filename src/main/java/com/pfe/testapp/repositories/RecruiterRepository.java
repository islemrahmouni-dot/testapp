package com.pfe.testapp.repositories;

import com.pfe.testapp.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

}