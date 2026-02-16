package com.pfe.testapp.repositories;

import com.pfe.testapp.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreEmploiRepository extends JpaRepository<OffreEmploi, Long> {
}
