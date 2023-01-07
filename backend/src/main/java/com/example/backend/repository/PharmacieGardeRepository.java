package com.example.backend.repository;

import com.example.backend.beans.PharmacieGarde;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into pharmacie_garde (garde_id, pharmacie_id, date) VALUES (?1, ?2,?3)", nativeQuery = true)
    void inserPharmacieGarde(int gardeId, int pharmacieId, String date);

    PharmacieGarde findById(int id);
}
