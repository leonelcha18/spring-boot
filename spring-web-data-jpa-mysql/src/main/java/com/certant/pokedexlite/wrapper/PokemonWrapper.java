package com.certant.pokedexlite.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.certant.pokedexlite.enums.SearchOption;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;

public class PokemonWrapper {
    private Long id;
    private String name;
    private Object types;
    private Integer levelIsFound;
    private Object abilities;
    private List<EvolutionWrapper> evolutions = new ArrayList<>();
    private SearchOption searchOption;

    public PokemonWrapper() {
    }

    public PokemonWrapper(Pokemon pk) {
        this.id = pk.getId();
        this.name = pk.getName();
        
        List<Type> pkTypes = new ArrayList<>(pk.getTypes());
        
        /*
        De contar con más de un Tipo, se asignará una lista, de lo contrario, 
        ya sea si cuenta con un Tipo o ninguno, se asignará un string
        */
        if (pkTypes.size() == 1) {
            String type = pkTypes.get(0).getName();

            this.types = type;
        } 
        else if (pkTypes.size() > 1) {
            List<String> listTps = new ArrayList<>();

            for (int i = 0; i < pkTypes.size(); i++) {
                listTps.add(pkTypes.get(i).getName());
            }

            this.types = listTps;
        } 
        else {
            String type = "";

            this.types = type;
        }
        
        this.levelIsFound = pk.getLevelIsFound();
        
        List<Ability> pkAbilities = new ArrayList<>(pk.getAbilities());
        
        /*
        De contar con más de una Habilidad, se asignará una lista, de lo contrario, 
        ya sea si cuenta con una Habilidad o ninguna, se asignará un string
        */        
        if (pkAbilities.size() == 1) {
            String ability = pkAbilities.get(0).getName();

            this.abilities = ability;
        } 
        else if (pkAbilities.size() > 1) {
            List<String> listAbilities = new ArrayList<>();

            for (int i = 0; i < pkAbilities.size(); i++) {
                listAbilities.add(pkAbilities.get(i).getName());
            }

            this.abilities = listAbilities;
        } 
        else {
            String ability = "";

            this.abilities = ability;
        }
        
        List<Evolution> pkEvolutions = new ArrayList<>(pk.getEvolutions());
        List<EvolutionWrapper> listEw = new ArrayList<>();
        
        for (Evolution tmpEv : pkEvolutions) {
            EvolutionWrapper ew = new EvolutionWrapper(tmpEv);
            listEw.add(ew);
        }
        
        this.evolutions = listEw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLevelIsFound() {
        return levelIsFound;
    }

    public void setLevelIsFound(Integer levelIsFound) {
        this.levelIsFound = levelIsFound;
    }

    public Object getAbilities() {
        return abilities;
    }

    public void setAbilities(Object abilities) {
        this.abilities = abilities;
    }

    public List<EvolutionWrapper> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(List<EvolutionWrapper> evolutions) {
        this.evolutions = evolutions;
    }

    public SearchOption getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(SearchOption searchOption) {
        this.searchOption = searchOption;
    }
    
    @Override
    public String toString() {
        return "PokemonWrapper{" + "id=" + id + ", name=" + name + ", levelIsFound=" + levelIsFound + '}';
    }
}