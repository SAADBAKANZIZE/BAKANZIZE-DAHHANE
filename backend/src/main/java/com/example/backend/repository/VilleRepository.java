package com.example.backend.repository;

import com.example.backend.beans.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findById(int id);
}
