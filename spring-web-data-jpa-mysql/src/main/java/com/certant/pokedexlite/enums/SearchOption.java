package com.certant.pokedexlite.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SearchOption {
    @JsonProperty("nombreTiposNivel")
    NOMBRE_TIPOS_NIVEL (0),
    @JsonProperty("habilidadesEvoluciones")
    HABILIDADES_EVOLUCIONES (1),
    @JsonProperty("evolucionesInformacion")
    EVOLUCIONES_INFORMACION (2);
    
    private final Integer value;
    
    public Integer getValue() {
        return value;
    }

    SearchOption(Integer value) {
        this.value = value;
    }
}