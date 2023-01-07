package com.example.backend.repository;

import com.example.backend.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query(value= "select *  from Zone ",nativeQuery = true)
    Collection<?> findAllZones();

    Zone findById(int id);
}
