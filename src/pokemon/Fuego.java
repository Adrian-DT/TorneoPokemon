package pokemon;

public class Fuego extends Pokemon {
	protected String ataqueEsp = "llamarada";

	public Fuego(String nombre, String tipo, int vida, int puntosMagia, boolean evolucionado) {
		super(nombre, tipo = "fuego", vida, puntosMagia);
		this.evolucionado = evolucionado;

	}

	// Setters y Getters
	public boolean isEvolucionado() {
		return evolucionado;
	}

	public void setEvolucionado(boolean evolucionado) {
		this.evolucionado = evolucionado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// Metodos

	public String ataqueEspecial(Pokemon pokemon) {
		// Método que evalua el daño que recibe el objeto Pokemon pasado por parámetro
		// en función del atributo tipo de Pokemon y reduce el atributo de magia del
		// atacante
		if (getPuntosMagia() % 5 == 0) {
			setPuntosMagia(getPuntosMagia() - 5);
			switch (pokemon.getTipo()) {
			case "fuego":
				pokemon.setVida(pokemon.getVida() - 20);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			case "planta":
				pokemon.setVida(pokemon.getVida() - 30);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			case "agua":
				pokemon.setVida(pokemon.getVida() - 10);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			}
			return getNombre() + " ha realizado el ataque especial 'llamarada' a " + pokemon.getNombre();
		}
		return getNombre() + " no ha podido realizar su ataque especial porque le quedan " + getPuntosMagia()
				+ " puntos de magia y por lo tanto falla su ataque.";
	}

	// Método que sobreescribe el del super para comporbar si un Pokemon evoluciona
	// o no, si evoluciona, cambia su
	// atributo de vida al máximo y cambia su atributo nombre en función de su
	// atributo nombre
	@Override
	public void evoluciona() {
		if (exp >= 3 && nombre == "Charmander") {
			evolucionado = true;
			nombre = "Charmeleon";
			setVidaInicial(100);
			System.out.println("¡¡Un pokemon está a punto de evolucionar!!");
			System.out.println("3...");
			System.out.println("2...");
			System.out.println("1...");
			System.out.println("¡¡Charmander ha evolucionado en Charmeleon!!");
		} else if (exp >= 3 && nombre == "Arcanine") {
			evolucionado = true;
			nombre = "Growlithe";
			setVidaInicial(100);
			System.out.println("¡¡Un pokemon está a punto de evolucionar!!");
			System.out.println("3...");
			System.out.println("2...");
			System.out.println("1...");
			System.out.println("¡¡Arcanine ha evolucionado en Growlithe!!\n");
		}

	}

}
