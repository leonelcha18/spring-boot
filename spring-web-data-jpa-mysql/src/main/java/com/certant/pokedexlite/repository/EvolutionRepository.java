package com.certant.pokedexlite.repository;

import com.certant.pokedexlite.model.Evolution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolutionRepository extends JpaRepository<Evolution, Long> {
    
}