package com.example.backend.repository;

import com.example.backend.beans.Pharmacie;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
    @Query(value= "select p from Pharmacie p  where p.zone.id = :id  ")
    List<Pharmacie> findByZone(@Param("id") int id);

    @Query(value= "select p from Pharmacie p  where p.pharmacien.id = :pharmacienId  ")
    List<Pharmacie> findByPharmacienId(@Param("pharmacienId") int pharmacienId);

    @Query(value= "select p  from Pharmacie p")
    List<Pharmacie> findAllPharmacies();


    @Query(value= "select p from Pharmacie p where p.zone.id = :zone_id  and p.zone.ville.id = :ville_id ")
    List<Pharmacie> findByZoneVille(@Param("zone_id") int zone_id, @Param("ville_id") int ville_id);

    @Query(value="select p from Pharmacie p where p.pharmacien.username = :username and p.pharmacien.password =  :password")
    List<Pharmacie> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


    Pharmacie findById(int id);
}
