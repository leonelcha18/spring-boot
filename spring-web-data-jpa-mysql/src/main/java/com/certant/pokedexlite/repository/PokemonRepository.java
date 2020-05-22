package com.certant.pokedexlite.repository;

import java.util.Optional;

import com.certant.pokedexlite.model.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    /**
     * Finds a pokemon by using the name as a search criteria
     * @param name
     * @return  A optional of type which name is an exact match with the given name
     *          If no type is found, this method returns an empty object
     */
    @Query("SELECT pk FROM Pokemon pk WHERE LOWER(pk.name) = LOWER(:name)")
    public Optional<Pokemon> findByName(@Param("name") String name);    
}