package com.certant.pokedexlite.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EvolutionWrapper {
    private String name;
    private Object types;
    private Integer levelNeeded;

    public EvolutionWrapper() {
    }

    public EvolutionWrapper(Evolution ev) {
        this.name = ev.getName();
        
        List<Type> evTypes = new ArrayList<>(ev.getTypes());
        
        /*
        De contar con más de un Tipo, se asignará una lista, de lo contrario, 
        ya sea si cuenta con un Tipo o ninguno, se asignará un string
        */
        if (evTypes.size() == 1) {
            String type = evTypes.get(0).getName();

            this.types = type;
        } 
        else if (evTypes.size() > 1) {
            List<String> listTps = new ArrayList<>();

            for (int i = 0; i < evTypes.size(); i++) {
                listTps.add(evTypes.get(i).getName());
            }

            this.types = listTps;
        } 
        else {
            String type = "";

            this.types = type;
        }
        
        this.levelNeeded = ev.getLevelNeeded();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTypes() {
        return types;
    }

    public void setTypes(Object types) {
        this.types = types;
    }

    public Integer getLevelNeeded() {
        return levelNeeded;
    }

    public void setLevelNeeded(Integer levelNeeded) {
        this.levelNeeded = levelNeeded;
    }

    @Override
    public String toString() {
        return "EvolutionWrapper{" + "name=" + name + ", levelNeeded=" + levelNeeded + '}';
    }
    
    @JsonIgnore
    public boolean isValid() {
        return (name != null && types != null && levelNeeded != null) && (!name.equalsIgnoreCase("") && levelNeeded != 0);
    }    
}