# PokemonMMO
Trabajo individual de programación perteneciente al tercer trimestre del primer curso de Desarrollo de Aplicaciones Multiplataforma

## Distribución obligatoria de los objetos
La estructura general del juego se basa en modelo, vista y controlador

El modelo se basa en una clase objeto padre de tipo "Pokemon" de la que extienden diferentes clases objeto que representarán a un pokemon en concreto, cada uno de esos objetos implementará los diferentes ataques, estos, se representarán cada uno como una interfaz y extendieran de una interfaz padre llamada "Attacks" que contendra los ataques genericos de todos los pokemon.
	
Para la Vista, crearé una clase objeto padre de tipo "Frame" que contendrá las caracteristicas básicas de la pantalla y de la que extenderan una seríe de clases que corresponderán con un tipo de vista diferente, estas, a su vez, implementarán una serie de interfaces que representarán a los elementos que contendrá la pantalla; de momento crearé un solo tipo de vista llamado "Battle".

El controlador se compondrá de una clase objeto de tipo "Motor" que contendrá los métodos necesaríos para el correcto funcionamiento del juego.