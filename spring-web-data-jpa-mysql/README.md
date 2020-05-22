# API REST pokedex-lite


# Tecnologías utilizadas:

Spring Boot, Spring Web, Spring Data JPA, MySQL Driver

Testing: Postman


# Entorno de ejecución:
Pre-requisitos: Apache Tomcat, MySQL y crear una base de datos llamada 'db_pokemons'

1 - Buildear el proyecto

2 - Copiar el .war de la carpeta target, y pegarlo en el directorio de Apache Tomcat .\apache-tomcat-x.x.xx\webapps

3 - Al desplegarse la aplicación, automaticamente ingresará registros a la base de datos


# Testing
Se debe contar con cualquier aplicación/herramient de Testing de API REST. En el proyecto en cuestión, se utilizó Postman.

URL ejemplos:
    http://localhost:8080/pokedex-lite/pokemon/1 | GET


    http://localhost:8080/pokedex-lite/pokemon?name=Bulbasaur | GET


    http://localhost:8080/pokedex-lite/pokemons


    http://localhost:8080/pokedex-lite/pokemon | POST

        body:
                {
                    "name": "Pikachu",
                    "types": [
                        "Electric"
                    ],
                    "levelIsFound": 10
                }


    http://localhost:8080/pokedex-lite/pokemon/8 | PUT

        body:
                {
                    "id": 8,
                    "name": "Spearow",
                    "types": [
                        "Poison",
                        "Electric"
                    ],
                    "levelIsFound": 16,
                    "abilities": [
                        "Keen Eye",
                        "Sniper"
                    ],
                    "evolutions": [
                        {
                            "name": "",
                            "types": "",
                            "levelNeeded": 0
                        }
                    ]
                }                


    http://localhost:8080/pokedex-lite/pokemon/2 | DELETE


Nota 1: El método POST, solo persiste los atributos name, types y levelIsFound
Nota 2: El método PUT, solo actualiza los atributos name, types y levelIsFound
Nota 3: El puerto puede variar, dependiendo la configuración del Apache Tomcat, pero por defecto es 8080