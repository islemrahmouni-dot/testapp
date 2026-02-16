package com.pfe.testapp.repositories;

import com.pfe.testapp.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {
}
