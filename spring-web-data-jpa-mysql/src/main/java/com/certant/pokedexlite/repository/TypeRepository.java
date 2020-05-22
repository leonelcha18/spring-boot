package com.certant.pokedexlite.repository;

import java.util.Optional;

import com.certant.pokedexlite.model.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends JpaRepository<Type, Long> {
    /**
     * Finds a type by using the name as a search criteria
     * @param name
     * @return  A optional of type which name is an exact match with the given name
     *          If no type is found, this method returns an empty object
     */
    @Query("SELECT tp FROM Type tp WHERE LOWER(tp.name) = LOWER(:name)")
    public Optional<Type> findByName(@Param("name") String name);    
}