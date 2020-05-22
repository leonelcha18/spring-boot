package com.certant.pokedexlite.util;

import java.util.ArrayList;

import com.certant.pokedexlite.dao.TypeDAO;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.wrapper.EvolutionWrapper;
import com.certant.pokedexlite.wrapper.PokemonWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParserUtil {
    @Autowired
    TypeDAO typeDAO;
    
    /**
     * Retorna un Pokemon, formatea los Tipos del PokemonWrapper
     * @param pw
     * @param pk
     * @return 
     */
    public Pokemon parseTypes(PokemonWrapper pw, Pokemon pk) {
        pk.removeTypes();
        /*
        De tratarse de una lista de Tipos, se buscará por nombre cada Tipo
        a través del Servicio, para luego asignarlo al Pokemon.
        Si se tratara de un solo elemento, el mismo será String y distinto de
        una cadena vacía, y se aplicará el mismo criterio.
        */         
        if (pw.getTypes().getClass().getSimpleName().equals("String") && !((String) pw.getTypes()).equals("")) {
            pk.addType(typeDAO.findByName((String) pw.getTypes()).get());
        } 
        else if (pw.getTypes().getClass().getSimpleName().equals("ArrayList")) {
            for (String stTmp : (ArrayList<String>) pw.getTypes()) {
                pk.addType(typeDAO.findByName(stTmp).get());

            }
        }
        
        return pk;
    }
    
    /**
     * Retorna una Evolucion, formatea los Tipos del EvolutionWrapper
     * @param ew
     * @param ev
     * @return 
     */
    public Evolution parseTypes(EvolutionWrapper ew, Evolution ev) {
        ev.removeTypes();
        /*
        De tratarse de una lista de Tipos, se buscará por nombre cada Tipo
        a través del Servicio, para luego asignarlo a la Evolucion.
        Si se tratara de un solo elemento, el mismo será String y distinto de
        una cadena vacía, y se aplicará el mismo criterio.
        */         
        if (ew.getTypes().getClass().getSimpleName().equals("String") && !((String) ew.getTypes()).equals("")) {
            ev.addType(typeDAO.findByName((String) ew.getTypes()).get());
        } 
        else if (ew.getTypes().getClass().getSimpleName().equals("ArrayList")) {
            for (String stTmp : (ArrayList<String>) ew.getTypes()) {
                ev.addType(typeDAO.findByName(stTmp).get());

            }
        }
        
        return ev;        
    }
}