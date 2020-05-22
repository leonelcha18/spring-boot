package com.certant.pokedexlite.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import javax.validation.Valid;

import com.certant.pokedexlite.dao.AbilityDAO;
import com.certant.pokedexlite.dao.EvolutionDAO;
import com.certant.pokedexlite.dao.PokemonDAO;
import com.certant.pokedexlite.dao.TypeDAO;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;
import com.certant.pokedexlite.util.ParserUtil;
import com.certant.pokedexlite.wrapper.PokemonWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PokemonController {
    @Autowired
    PokemonDAO pokemonDAO;
    @Autowired
    TypeDAO typeDAO;
    @Autowired
    AbilityDAO abilityDAO;
    @Autowired
    EvolutionDAO evolutionDAO;      
    @Autowired
    ParserUtil parserUtil;
    
    /**
     * Crea un Pokemon, enviado por la vista en formato JSON
     * Envía a la vista, el Pokemon creado
     * @param pw
     * @return 
     */
    @PostMapping("/pokemon")
    public PokemonWrapper createPokemon( @RequestBody PokemonWrapper pw) {
        Pokemon tmpPk = new Pokemon(pw);
        Pokemon pk = parserUtil.parseTypes(pw, tmpPk);
        
        pokemonDAO.save(pk);      

        for (Type tmpTp : pk.getTypes()) {
            tmpTp.addPokemon(pokemonDAO.findById(pk.getId()).get());
            typeDAO.save(tmpTp);
        }
        
        PokemonWrapper tmpPw = new PokemonWrapper(pk);
        
        return tmpPw;
    }
    
    /**
     * Envía a la vista, el listado de Pokemones en formato JSON
     * @return 
     */
    @GetMapping("/pokemons")
    public List<PokemonWrapper> getAllPokemons() {
        List<Pokemon> pks = new ArrayList<>(pokemonDAO.findAll());    
        List<PokemonWrapper> pws = new ArrayList<>();
        
        for (int i = 0; i < pks.size(); i++) {
            PokemonWrapper pw = new PokemonWrapper(pks.get(i));
            pws.add(pw);
        }
        
        return pws;
    }

    /**
     * Envía a la vista, el Pokemon solicitado por uri, en formato JSON
     * El Pokemon se obtiene por id
     * @param id
     * @return 
     */
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonWrapper> getPokemonById(@PathVariable(value = "id") Long id) {
        Optional<Pokemon> optionalPk = pokemonDAO.findById(id);
        
        if (!optionalPk.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Pokemon pk = optionalPk.get();
        
        PokemonWrapper wp = new PokemonWrapper(pk);
        
        return ResponseEntity.ok().body(wp);
    }
    
    /**
     * Envía a la vista, el Pokemon solicitado por uri, en formato JSON
     * El Pokemon se obtiene por nombre
     * @param name
     * @return 
     */
    @GetMapping("/pokemon")
    public ResponseEntity<PokemonWrapper> getPokemonByName(@RequestParam("name") String name) {
        Optional<Pokemon> optionalPk = pokemonDAO.findByName(name);
        
        if (!optionalPk.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Pokemon pk = optionalPk.get();
        
        PokemonWrapper wp = new PokemonWrapper(pk);
        
        return ResponseEntity.ok().body(wp);
    }    
    
    /**
     * Actualiza los datos de un Pokemon, enviado por la vista en formato JSON
     * El Pokemon original se obtiene por id
     * Envía a la vista, el Pokemon modificado
     * @param id
     * @param pw
     * @return 
     */
    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonWrapper> updatePokemon(@PathVariable(value = "id") Long id, @Valid @RequestBody PokemonWrapper pw) {
        Optional<Pokemon> optionalPk = pokemonDAO.findById(id);
        
        if (!optionalPk.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Pokemon origPk = optionalPk.get();
        
        for (Type tmpTp : origPk.getTypes()) {
            tmpTp.removePokemon(origPk);
            typeDAO.save(tmpTp);
        }
        
        pokemonDAO.save(origPk);
        
        //
        origPk.setName(pw.getName());
        origPk.setLevelIsFound(pw.getLevelIsFound());
        Pokemon tmpPk1 = parserUtil.parseTypes(pw, origPk);
        
        pokemonDAO.save(tmpPk1);

        for (Type tmpTp : tmpPk1.getTypes()) {
            tmpTp.addPokemon(pokemonDAO.findById(id).get());
            typeDAO.save(tmpTp);
        }
        
        if (pw.getEvolutions().get(0).isValid()) {
            Evolution orgEv = new Evolution(pw.getEvolutions().get(0));
            Evolution ev = parserUtil.parseTypes(pw.getEvolutions().get(0), orgEv);
            
            evolutionDAO.save(ev);
            
            Pokemon tmpPk2 = pokemonDAO.findById(id).get();
            tmpPk2.addEvolution(ev);
            pokemonDAO.save(tmpPk2);
            
            for (Type tmpTp : ev.getTypes()) {
                tmpTp.addEvolution(evolutionDAO.findById(ev.getId()).get());
                typeDAO.save(tmpTp);
            }
            
            ev.setPokemon(tmpPk2);
            evolutionDAO.save(ev);
        }
        
        Pokemon tmpPk2 = pokemonDAO.findById(id).get();
        
        PokemonWrapper tmpPw = new PokemonWrapper(tmpPk2);
        
        return ResponseEntity.ok().body(tmpPw);
    }
    
    /**
     * Elimina un Pokemon, por uri
     * El Pokemon se obtiene por id
     * Envía a la vista, el Pokemon eliminado
     * @param id
     * @return 
     */
    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<PokemonWrapper> deletePokemon(@PathVariable(value = "id") Long id) {
        Optional<Pokemon> optionalPk = pokemonDAO.findById(id);
        
        if (!optionalPk.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Pokemon pk = optionalPk.get();
        PokemonWrapper pw = new PokemonWrapper(pk);
        
        for (Type tmpTp : pk.getTypes()) {
            tmpTp.removePokemon(pk);
            typeDAO.save(tmpTp);
        }
        
        for (Ability tmpAy : pk.getAbilities()) {
            tmpAy.removePokemon(pk);
            abilityDAO.save(tmpAy);
        }
        
        for (Evolution tmpEv : pk.getEvolutions()) {
            tmpEv.setPokemon(null);
            evolutionDAO.save(tmpEv);
        }        
        
        pokemonDAO.delete(pk);
        
        return ResponseEntity.ok().body(pw);
    }
}