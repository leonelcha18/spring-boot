package com.certant.pokedexlite.dao;

import java.util.List;
import java.util.Optional;

import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonDAO {
    @Autowired
    PokemonRepository pokemonRepository;
    
    /**
     * Guarda un Pokemon
     * Retorna el Pokemon guardado
     * @param pokemon
     * @return 
     */
    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    
    /**
     * Lista todos los Pokemones
     * @return 
     */
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
    
    /**
     * Retorna un Pokemon
     * El Pokemon se busca por id
     * @param id
     * @return 
     */
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }
    
    /**
     * Retorna un Pokemon
     * El Pokemon se busca por nombre
     * @param name
     * @return 
     */
    public Optional<Pokemon> findByName(String name) {
        return pokemonRepository.findByName(name);
    }    
    
    /**
     * Elimina un Pokemon
     * @param pokemon 
     */
    public void delete(Pokemon pokemon) {
        pokemonRepository.delete(pokemon);
    }
}