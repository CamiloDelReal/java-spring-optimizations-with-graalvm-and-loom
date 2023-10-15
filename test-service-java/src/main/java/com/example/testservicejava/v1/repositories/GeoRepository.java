package com.example.testservicejava.v1.repositories;

import com.example.testservicejava.v1.entities.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends JpaRepository<Geo, Long> {}
