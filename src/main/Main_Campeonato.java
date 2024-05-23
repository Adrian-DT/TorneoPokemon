package main;

import pokemon.Agua;
import pokemon.Fuego;
import pokemon.Planta;
import pokemon.Pokemon;

public class Main_Campeonato {

	public static void main(String[] args) {
		//Array de pokemons, donde guardaremos pokemons de cualquier clase
		Pokemon[] participantes = new Pokemon[4];
		Fuego charmander = new Fuego("Charmander", "fuego", 80, 15, false);
		Fuego arcanine = new Fuego("Arcanine", "fuego", 70, 20, false);
		Agua squirtle = new Agua("Squirtle", "agua", 90, 20, false);
		Planta bulbasur = new Planta("Bulbasur", "planta", 60, 20, false);
		participantes[0] = charmander;
		participantes[1] = arcanine;
		participantes[2] = squirtle;
		participantes[3] = bulbasur;

		campeonato(participantes);
	}

	// Metodos
	// Método que realiza el campeonato
	public static void campeonato(Pokemon[] participantes) {
		// Declaro la variable ronda para mostrarla mediante un print
		int ronda = 1;
		// Bucle anidado for para realizar las rondas entre todos los objetos del array
		// participantes, iniciando una posicion aleatoria del array
		for (int i = (int) (Math.random() * 3); i < participantes.length; i++) {
			for (int j = 0; j < participantes.length; j++) {
				// Controlo que el combate se realiza si los participantes son diferentes
				if (participantes[i] != participantes[j]) {
					System.out.println("******************");
					System.out.println("*    COMBATE " + ronda + "   *");
					System.out.println("*  ESTADISTICAS  *");
					System.out.println("******************");
					System.out.println(participantes[i].getInfo());
					System.out.println();
					System.out.println(participantes[j].getInfo());
					System.out.println();
					// Mientras alguno de los participantes tenga vida, ataca primero uno y luego
					// ataca el otro
					while (participantes[i].getVida() > 0 && participantes[j].getVida() > 0) {
						participantes[i].tipoAtaque(participantes[j]);
						participantes[j].tipoAtaque(participantes[i]);
					}
					// Reinicio los atributos de los participantes y aumento la ronda
					participantes[i].reinicioStats();
					participantes[j].reinicioStats();
					ronda++;
				}
			}

		}

	}
}
