package pokemon;

public class Planta extends Pokemon {

	public Planta(String nombre, String tipo, int vida, int puntosMagia, boolean evolucionado) {
		super(nombre, tipo = "planta", vida, puntosMagia);
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

	// Método que evalua el daño que recibe el objeto Pokemon pasado por parámetro
	// en función del atributo tipo de Pokemon y reduce el atributo de magia del
	// atacante
	public String ataqueEspecial(Pokemon pokemon) {
		if (getPuntosMagia() % 5 == 0) {
			setPuntosMagia(getPuntosMagia() - 5);
			switch (pokemon.getTipo()) {
			case "fuego":
				pokemon.setVida(pokemon.getVida() - 10);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			case "planta":
				pokemon.setVida(pokemon.getVida() - 20);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			case "agua":
				pokemon.setVida(pokemon.getVida() - 30);
				if (pokemon.getVida() < 0) {
					pokemon.setVida(0);
				}
				break;
			}
			return getNombre() + " ha realizado el ataque especial 'látigo cepa' a " + pokemon.getNombre();
		}
		return getNombre() + " no ha podido realizar su ataque especial porque le quedan " + getPuntosMagia()
				+ " puntos de magia y por lo tanto falla su ataque.";
	}

	// Método que sobreescribe el del super para comporbar si un Pokemon evoluciona
	// o no, si evoluciona, cambia su
	// atributo de vida al máximo y cambia su atributo nombre
	@Override
	public void evoluciona() {
		if (exp >= 3) {
			evolucionado = true;
			nombre = "Ivysaur";
			setVidaInicial(100);
			System.out.println("¡¡Un pokemon está a punto de evolucionar!!");
			System.out.println("3...");
			System.out.println("2...");
			System.out.println("1...");
			System.out.println("¡¡Bulbasur ha evolucionado en Ivysaur!!\n");
		}

	}

}
