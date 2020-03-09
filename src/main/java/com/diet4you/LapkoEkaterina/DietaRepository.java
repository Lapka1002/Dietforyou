package com.diet4you.LapkoEkaterina;

import com.diet4you.LapkoEkaterina.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaRepository extends JpaRepository<Dieta, Integer> {
    Dieta findByNazwa (Integer nazwa);
}