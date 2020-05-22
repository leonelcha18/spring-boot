package com.certant.pokedexlite.dao;

import java.util.List;
import java.util.Optional;

import com.certant.pokedexlite.model.Type;
import com.certant.pokedexlite.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeDAO {
    @Autowired
    TypeRepository typeRepository;
    
    /**
     * Guarda un Tipo
     * Retorna el Tipo guardado
     * @param type
     * @return 
     */
    public Type save(Type type) {
        return typeRepository.save(type);
    }    
    
    /**
     * Lista todos los Tipos
     * @return 
     */
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
    
    /**
     * Retorna un Tipo
     * El Tipo se busca por id
     * @param id
     * @return 
     */
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }
    
    /**
     * Retorna un Tipo
     * El Tipo se busca por nombre
     * @param name
     * @return 
     */
    public Optional<Type> findByName(String name) {
        return typeRepository.findByName(name);
    }
}