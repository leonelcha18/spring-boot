package com.certant.pokedexlite.dao;

import java.util.Optional;

import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.repository.EvolutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvolutionDAO {
    @Autowired
    EvolutionRepository evolutionRepository;
    
    /**
     * Guarda una Evolucion
     * Retorna la Evolucion guardada
     * @param evolution
     * @return 
     */
    public Evolution save(Evolution evolution) {
        return evolutionRepository.save(evolution);
    }    
    
    /**
     * Retorna una Evolucion
     * La Evolucion se busca por id
     * @param id
     * @return 
     */
    public Optional<Evolution> findById(Long id) {
        return evolutionRepository.findById(id);
    }    
}