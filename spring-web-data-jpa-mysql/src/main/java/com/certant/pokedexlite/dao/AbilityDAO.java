package com.certant.pokedexlite.dao;

import java.util.List;
import java.util.Optional;

import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.repository.AbilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityDAO {
    @Autowired
    AbilityRepository abilityRepository;    
    
    /**
     * Guarda una Habilidad
     * Retorna la Habilidad guardada
     * @param ability
     * @return 
     */
    public Ability save(Ability ability) {
        return abilityRepository.save(ability);
    }    
    
    /**
     * Lista todas las Habilidades
     * @return 
     */
    public List<Ability> findAll() {
        return abilityRepository.findAll();
    }
    
    /**
     * Retorna una Habilidad
     * La Habilidad se busca por id
     * @param id
     * @return 
     */
    public Optional<Ability> findById(Long id) {
        return abilityRepository.findById(id);
    }    
}