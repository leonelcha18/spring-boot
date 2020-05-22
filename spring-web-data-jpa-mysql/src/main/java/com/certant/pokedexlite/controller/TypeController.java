package com.certant.pokedexlite.controller;

import java.util.List;

import com.certant.pokedexlite.dao.TypeDAO;
import com.certant.pokedexlite.model.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TypeController {
    @Autowired
    TypeDAO typeDAO;    
    
    /**
     * Envía a la vista, el listado de Tipos en formato JSON
     * @return 
     */
    @GetMapping("/types")
    public List<Type> getAllPokemons() {
        List<Type> types = typeDAO.findAll();
        
        types.forEach((tmpTp) -> {
            tmpTp.removePokemons();
        });
        
        return types;
    }    
}