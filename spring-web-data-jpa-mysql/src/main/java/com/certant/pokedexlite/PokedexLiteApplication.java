package com.certant.pokedexlite;

import com.certant.pokedexlite.dao.AbilityDAO;
import com.certant.pokedexlite.dao.EvolutionDAO;
import com.certant.pokedexlite.dao.PokemonDAO;
import com.certant.pokedexlite.dao.TypeDAO;
import com.certant.pokedexlite.model.Ability;
import com.certant.pokedexlite.model.Evolution;
import com.certant.pokedexlite.model.Pokemon;
import com.certant.pokedexlite.model.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PokedexLiteApplication extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    PokemonDAO pokemonDAO;
    @Autowired
    TypeDAO typeDAO;
    @Autowired
    AbilityDAO abilityDAO;
    @Autowired
    EvolutionDAO evolutionDAO;    
    
    public static void main(String[] args) {
        SpringApplication.run(PokedexLiteApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PokedexLiteApplication.class);
    }

    /**
     * Genera registros para la base de datos
     * @param args
     * @throws Exception 
     */
    @Override
    public void run(String... args) throws Exception {
        //Types
        Type tp1 = new Type();
        tp1.setName("Normal");
        
        Type tp2 = new Type();
        tp2.setName("Fire");
        
        Type tp3 = new Type();
        tp3.setName("Water");
        
        Type tp4 = new Type();
        tp4.setName("Electric");
        
        Type tp5 = new Type();
        tp5.setName("Grass");
        
        Type tp6 = new Type();
        tp6.setName("Ice");
        
        Type tp7 = new Type();
        tp7.setName("Fighting");
        
        Type tp8 = new Type();
        tp8.setName("Poison");
        
        Type tp9 = new Type();
        tp9.setName("Ground");
        
        Type tp10 = new Type();
        tp10.setName("Flying");
        
        Type tp11 = new Type();
        tp11.setName("Psychic");
        
        Type tp12 = new Type();
        tp12.setName("Bug");
        
        Type tp13 = new Type();
        tp13.setName("Rock");
        
        Type tp14 = new Type();
        tp14.setName("Ghost");
        
        Type tp15 = new Type();
        tp15.setName("Dragon");
        
        Type tp16 = new Type();
        tp16.setName("Dark");
        
        Type tp17 = new Type();
        tp17.setName("Steel");
        
        Type tp18 = new Type();
        tp18.setName("Fairy");

        typeDAO.save(tp1);
        typeDAO.save(tp2);
        typeDAO.save(tp3);
        typeDAO.save(tp4);
        typeDAO.save(tp5);
        typeDAO.save(tp6);
        typeDAO.save(tp7);
        typeDAO.save(tp8);
        typeDAO.save(tp9);
        typeDAO.save(tp10);
        typeDAO.save(tp11);
        typeDAO.save(tp12);
        typeDAO.save(tp13);
        typeDAO.save(tp14);
        typeDAO.save(tp15);
        typeDAO.save(tp16);
        typeDAO.save(tp17);
        typeDAO.save(tp18);
        
        //Abilities
        Ability ay1 = new Ability();
        ay1.setName("Overgrow");
        
        Ability ay2 = new Ability();
        ay2.setName("Chlorophyll");

        Ability ay3 = new Ability();
        ay3.setName("Blaze");

        Ability ay4 = new Ability();
        ay4.setName("Solar Power");

        Ability ay5 = new Ability();
        ay5.setName("Torrent");

        Ability ay6 = new Ability();
        ay6.setName("Rain Dish");

        Ability ay7 = new Ability();
        ay7.setName("Shield Dust");

        Ability ay8 = new Ability();
        ay8.setName("Run Away");

        Ability ay9 = new Ability();
        ay9.setName("Keen Eye");

        Ability ay10 = new Ability();
        ay10.setName("Tangled Feet");

        Ability ay11 = new Ability();
        ay11.setName("Guts");

        Ability ay12 = new Ability();
        ay12.setName("Hustle");    

        Ability ay13 = new Ability();
        ay13.setName("Sniper");    

        Ability ay14 = new Ability();
        ay14.setName("Intimidate");    

        Ability ay15 = new Ability();
        ay15.setName("Shed Skin");    

        Ability ay16 = new Ability();
        ay16.setName("Unnerve");    

        Ability ay17 = new Ability();
        ay17.setName("Sand Veil");    

        Ability ay18 = new Ability();
        ay18.setName("Sand Rush");
        
        Ability ay19 = new Ability();
        ay19.setName("Effect Spore"); 
        
        Ability ay20 = new Ability();
        ay20.setName("Dry Skin");
        
        Ability ay21 = new Ability();
        ay21.setName("Damp");
        
        abilityDAO.save(ay1);
        abilityDAO.save(ay2);
        abilityDAO.save(ay3);
        abilityDAO.save(ay4);
        abilityDAO.save(ay5);
        abilityDAO.save(ay6);
        abilityDAO.save(ay7);
        abilityDAO.save(ay8);
        abilityDAO.save(ay9);
        abilityDAO.save(ay10);
        abilityDAO.save(ay11);
        abilityDAO.save(ay12);
        abilityDAO.save(ay13);
        abilityDAO.save(ay14);
        abilityDAO.save(ay15);
        abilityDAO.save(ay16);
        abilityDAO.save(ay17);
        abilityDAO.save(ay18);
        abilityDAO.save(ay19);
        abilityDAO.save(ay20);
        abilityDAO.save(ay21);
        
        //Evolutions
        Evolution ev1 = new Evolution();
        ev1.setName("Ivysaur");
        ev1.addType(typeDAO.findById(5l).get());
        ev1.addType(typeDAO.findById(8l).get());
        ev1.setLevelNeeded(16);
        
        Evolution ev2 = new Evolution();
        ev2.setName("Venusaur");
        ev2.addType(typeDAO.findById(5l).get());
        ev2.addType(typeDAO.findById(8l).get());
        ev2.setLevelNeeded(32);

        Evolution ev3 = new Evolution();
        ev3.setName("Charmeleon");
        ev3.addType(typeDAO.findById(2l).get());
        ev3.setLevelNeeded(16);
        
        Evolution ev4 = new Evolution();
        ev4.setName("Charizard");
        ev4.addType(typeDAO.findById(2l).get());
        ev4.setLevelNeeded(36);

        Evolution ev5 = new Evolution();
        ev5.setName("Wartortle");
        ev5.addType(typeDAO.findById(3l).get());
        ev5.setLevelNeeded(16);
        
        Evolution ev6 = new Evolution();
        ev6.setName("Blastoise");
        ev6.addType(typeDAO.findById(3l).get());
        ev6.setLevelNeeded(36);

        Evolution ev7 = new Evolution();
        ev7.setName("Metapod");
        ev7.addType(typeDAO.findById(12l).get());
        ev7.setLevelNeeded(7);
        
        Evolution ev8 = new Evolution();
        ev8.setName("Butterfree");
        ev8.addType(typeDAO.findById(10l).get());
        ev8.addType(typeDAO.findById(12l).get());
        ev8.setLevelNeeded(10);         

        Evolution ev9 = new Evolution();
        ev9.setName("Kakuna");
        ev9.addType(typeDAO.findById(8l).get());
        ev9.addType(typeDAO.findById(12l).get());        
        ev9.setLevelNeeded(7);
        
        Evolution ev10 = new Evolution();
        ev10.setName("Beedrill");
        ev10.addType(typeDAO.findById(8l).get());
        ev10.addType(typeDAO.findById(12l).get());         
        ev10.setLevelNeeded(10);

        Evolution ev11 = new Evolution();
        ev11.setName("Pidgeotto");
        ev11.addType(typeDAO.findById(1l).get());
        ev11.addType(typeDAO.findById(10l).get());           
        ev11.setLevelNeeded(18);
        
        Evolution ev12 = new Evolution();
        ev12.setName("Pidgeot");
        ev12.addType(typeDAO.findById(1l).get());
        ev12.addType(typeDAO.findById(10l).get());  
        ev12.setLevelNeeded(36);         

        Evolution ev13 = new Evolution();
        ev13.setName("Raticate");
        ev13.addType(typeDAO.findById(1l).get());
        ev13.setLevelNeeded(20);
        
        Evolution ev14 = new Evolution();
        ev14.setName("Fearow");
        ev14.addType(typeDAO.findById(1l).get());
        ev14.addType(typeDAO.findById(10l).get());          
        ev14.setLevelNeeded(20);

        Evolution ev15 = new Evolution();
        ev15.setName("Arbok");
        ev15.addType(typeDAO.findById(8l).get());
        ev15.setLevelNeeded(22);
        
        Evolution ev16 = new Evolution();
        ev16.setName("Sandslash");
        ev16.addType(typeDAO.findById(9l).get());
        ev16.setLevelNeeded(22);

        Evolution ev17 = new Evolution();
        ev17.setName("Parasect");
        ev17.addType(typeDAO.findById(5l).get());
        ev17.addType(typeDAO.findById(12l).get());
        ev17.setLevelNeeded(24);    
        
        evolutionDAO.save(ev1);
        evolutionDAO.save(ev2);
        evolutionDAO.save(ev3);
        evolutionDAO.save(ev4);
        evolutionDAO.save(ev5);
        evolutionDAO.save(ev6);
        evolutionDAO.save(ev7);
        evolutionDAO.save(ev8);
        evolutionDAO.save(ev9);
        evolutionDAO.save(ev10);
        evolutionDAO.save(ev11);
        evolutionDAO.save(ev12);
        evolutionDAO.save(ev13);
        evolutionDAO.save(ev14);
        evolutionDAO.save(ev15);
        evolutionDAO.save(ev16);
        evolutionDAO.save(ev17);

        //Relations
        //Pokemon01
        Pokemon pk1 = new Pokemon();
        pk1.setName("Bulbasaur");
        pk1.addType(typeDAO.findById(5l).get());
        pk1.addType(typeDAO.findById(8l).get());
        pk1.setLevelIsFound(4);
        pk1.addAbility(abilityDAO.findById(1l).get());
        pk1.addAbility(abilityDAO.findById(2l).get());
        pk1.addEvolution(evolutionDAO.findById(1l).get());
        pk1.addEvolution(evolutionDAO.findById(2l).get());        
        
        pokemonDAO.save(pk1);
        
        for (Type tmpTp : pk1.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(1l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk1.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(1l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk1.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(1l).get());
            evolutionDAO.save(ev);
        }

        for (Type tmpTp : ev1.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev1.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev2.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev2.getId()).get());
            typeDAO.save(type);
        }

        
        //Pokemon02
        Pokemon pk2 = new Pokemon();
        pk2.setName("Charmander");
        pk2.addType(typeDAO.findById(2l).get());
        pk2.setLevelIsFound(1);
        pk2.addAbility(abilityDAO.findById(3l).get());
        pk2.addAbility(abilityDAO.findById(4l).get());
        pk2.addEvolution(evolutionDAO.findById(3l).get()); 
        pk2.addEvolution(evolutionDAO.findById(4l).get()); 
        
        pokemonDAO.save(pk2);
        
        for (Type tmpTp : pk2.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(2l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk2.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(2l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk2.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(2l).get());
            evolutionDAO.save(ev);
        }

        for (Type tmpTp : ev3.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev3.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev4.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev4.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon03
        Pokemon pk3 = new Pokemon();
        pk3.setName("Squirtle");
        pk3.addType(typeDAO.findById(3l).get());
        pk3.setLevelIsFound(10);
        pk3.addAbility(abilityDAO.findById(5l).get());
        pk3.addAbility(abilityDAO.findById(6l).get());
        pk3.addEvolution(evolutionDAO.findById(5l).get()); 
        pk3.addEvolution(evolutionDAO.findById(6l).get());
        
        pokemonDAO.save(pk3);
        
        for (Type tmpTp : pk3.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(3l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk3.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(3l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk3.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(3l).get());
            evolutionDAO.save(ev);
        }

        for (Type tmpTp : ev5.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev5.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev6.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev6.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon04
        Pokemon pk4 = new Pokemon();
        pk4.setName("Caterpie");
        pk4.addType(typeDAO.findById(12l).get());
        pk4.setLevelIsFound(2);
        pk4.addAbility(abilityDAO.findById(7l).get());
        pk4.addAbility(abilityDAO.findById(8l).get());
        pk4.addEvolution(evolutionDAO.findById(7l).get()); 
        pk4.addEvolution(evolutionDAO.findById(8l).get());
        
        pokemonDAO.save(pk4);
        
        for (Type tmpTp : pk4.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(4l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk4.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(4l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk4.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(4l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev7.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev7.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev8.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev8.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon05
        Pokemon pk5 = new Pokemon();
        pk5.setName("Weedle");
        pk5.addType(typeDAO.findById(8l).get());
        pk5.addType(typeDAO.findById(12l).get());
        pk5.setLevelIsFound(6);
        pk5.addAbility(abilityDAO.findById(7l).get());
        pk5.addAbility(abilityDAO.findById(8l).get());
        pk5.addEvolution(evolutionDAO.findById(9l).get()); 
        pk5.addEvolution(evolutionDAO.findById(10l).get());
        
        pokemonDAO.save(pk5);
        
        for (Type tmpTp : pk5.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(5l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk5.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(5l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk5.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(5l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev9.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev9.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev10.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev10.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon06
        Pokemon pk6 = new Pokemon();
        pk6.setName("Pidgey");
        pk6.addType(typeDAO.findById(1l).get());
        pk6.addType(typeDAO.findById(10l).get());
        pk6.setLevelIsFound(6);
        pk6.addAbility(abilityDAO.findById(9l).get());
        pk6.addAbility(abilityDAO.findById(10l).get());
        pk6.addEvolution(evolutionDAO.findById(11l).get()); 
        pk6.addEvolution(evolutionDAO.findById(12l).get());
        
        pokemonDAO.save(pk6);
        
        for (Type tmpTp : pk6.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(6l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk6.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(6l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk6.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(6l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev11.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev11.getId()).get());
            typeDAO.save(type);
        }
        
        for (Type tmpTp : ev12.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev12.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon07
        Pokemon pk7 = new Pokemon();
        pk7.setName("Rattata");
        pk7.addType(typeDAO.findById(1l).get());
        pk7.setLevelIsFound(15);
        pk7.addAbility(abilityDAO.findById(8l).get());
        pk7.addAbility(abilityDAO.findById(11l).get());
        pk7.addAbility(abilityDAO.findById(12l).get());
        pk7.addEvolution(evolutionDAO.findById(13l).get()); 
        
        pokemonDAO.save(pk7);
        
        for (Type tmpTp : pk7.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(7l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk7.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(7l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk7.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(7l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev13.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev13.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon08
        Pokemon pk8 = new Pokemon();
        pk8.setName("Spearow");
        pk8.addType(typeDAO.findById(1l).get());
        pk8.addType(typeDAO.findById(10l).get());
        pk8.setLevelIsFound(13);
        pk8.addAbility(abilityDAO.findById(9l).get());
        pk8.addAbility(abilityDAO.findById(13l).get());
        pk8.addEvolution(evolutionDAO.findById(14l).get()); 
        
        pokemonDAO.save(pk8);
        
        for (Type tmpTp : pk8.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(8l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk8.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(8l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk8.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(8l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev14.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev14.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon09
        Pokemon pk9 = new Pokemon();
        pk9.setName("Ekans");
        pk9.addType(typeDAO.findById(8l).get());
        pk9.setLevelIsFound(21);
        pk9.addAbility(abilityDAO.findById(14l).get());
        pk9.addAbility(abilityDAO.findById(15l).get());
        pk9.addAbility(abilityDAO.findById(16l).get());
        pk9.addEvolution(evolutionDAO.findById(15l).get()); 
        
        pokemonDAO.save(pk9);
        
        for (Type tmpTp : pk9.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(9l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk9.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(9l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk9.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(9l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev15.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev15.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon10
        Pokemon pk10 = new Pokemon();
        pk10.setName("Sandshrew");
        pk10.addType(typeDAO.findById(9l).get());
        pk10.setLevelIsFound(19);
        pk10.addAbility(abilityDAO.findById(17l).get());
        pk10.addAbility(abilityDAO.findById(18l).get());
        pk10.addEvolution(evolutionDAO.findById(16l).get()); 
        
        pokemonDAO.save(pk10);
        
        for (Type tmpTp : pk10.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(10l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk10.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(10l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk10.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(10l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev16.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev16.getId()).get());
            typeDAO.save(type);
        }
        
        //Pokemon11
        Pokemon pk11 = new Pokemon();
        pk11.setName("Paras");
        pk11.addType(typeDAO.findById(5l).get());
        pk11.addType(typeDAO.findById(12l).get());
        pk11.setLevelIsFound(2);
        pk11.addAbility(abilityDAO.findById(19l).get());
        pk11.addAbility(abilityDAO.findById(20l).get());
        pk11.addAbility(abilityDAO.findById(21l).get());
        pk11.addEvolution(evolutionDAO.findById(17l).get()); 
        
        pokemonDAO.save(pk11);
        
        for (Type tmpTp : pk11.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addPokemon(pokemonDAO.findById(11l).get());
            typeDAO.save(type);
        }        
        
        for (Ability tmpAy : pk11.getAbilities()) {
            Ability ability = abilityDAO.findById(tmpAy.getId()).get();
            ability.addPokemon(pokemonDAO.findById(11l).get());
            abilityDAO.save(ability);
        }
        
        for (Evolution tmpEv : pk11.getEvolutions()) {
            Evolution ev = evolutionDAO.findById(tmpEv.getId()).get();
            ev.setPokemon(pokemonDAO.findById(11l).get());
            evolutionDAO.save(ev);
        }
        
        for (Type tmpTp : ev17.getTypes()) {
            Type type = typeDAO.findById(tmpTp.getId()).get();
            type.addEvolution(evolutionDAO.findById(ev17.getId()).get());
            typeDAO.save(type);
        }        
    }
}