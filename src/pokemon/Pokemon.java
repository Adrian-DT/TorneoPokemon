package pokemon;

abstract public class Pokemon {
	protected String nombre, tipo;
	protected int vida, vidaInicial, puntosMagia, puntosMagiaInicial, exp;
	protected boolean evolucionado = false;

	public Pokemon(String nombre, String tipo, int vida, int puntosMagia) {
		setNombre(nombre);
		setTipo(tipo);
		setVida(vida);
		setPuntosMagia(puntosMagia);
		setExp(1);
		setVidaInicial(vida);
		setPuntosMagiaInicial(puntosMagia);
	}

	// Setters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPuntosMagia() {
		return puntosMagia;
	}

	public void setPuntosMagia(int puntosMagia) {
		this.puntosMagia = puntosMagia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEvolucionado() {
		return evolucionado;
	}

	public void setEvolucionado(boolean evolucionado) {
		this.evolucionado = evolucionado;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}

	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial = vidaInicial;
	}

	public int getPuntosMagiaInicial() {
		return puntosMagiaInicial;
	}

	public void setPuntosMagiaInicial(int puntosMagiaInicial) {
		this.puntosMagiaInicial = puntosMagiaInicial;
	}

	// Metodos

	// Método de ataque básico a realizar sobre el objeto Pokemon pasado por
	// parámetro
	public String ataqueBasico(Pokemon pokemon) {
		pokemon.setVida(pokemon.getVida() - 10);
		if (pokemon.getVida() < 0) {
			pokemon.setVida(0);
		}
		return getNombre() + " realiza un ataque básico con éxito a " + pokemon.getNombre()
				+ " reduciendo su vida en 10";
	}

	// Método abstracto para obligar a heredarlo en sus hijos
	public abstract String ataqueEspecial(Pokemon pokemon);

	// Método que controla si el Pokemon evoluciona y cambia el valor booleano a
	// true
	public void evoluciona() {
		if (exp >= 2) {
			evolucionado = true;
		}
		nombre = "";
	}

	// Método para controlar el tipo de ataque a utilizar de manera aleatoria, una
	// proporcion de 2 a 3 y 1 a 3, llamando al atque especial del objeto heredado y
	// comprueba con el metodo ganador() quién gana
	public void tipoAtaque(Pokemon pokemon) {
		int tipoAtaque = (int) (Math.random() * 3);
		if (vida > 0) {
			if (tipoAtaque < 3) {
				ataqueBasico(pokemon);
				System.out.println(nombre + " realiza un ataque básico contra " + pokemon.nombre);
				System.out.println(nombre + ": " + vida + " " + puntosMagia);
				System.out.println(pokemon.nombre + ": " + pokemon.vida + " " + pokemon.puntosMagia + "\n");

			} else {
				ataqueEspecial(pokemon);
				System.out.println(nombre + " realiza su ataque especial contra " + pokemon.nombre);
				System.out.println(nombre + ": " + vida + " " + puntosMagia);
				System.out.println(pokemon.nombre + ": " + pokemon.vida + " " + pokemon.puntosMagia + "\n");

			}

		}
		ganador(pokemon);
	}

	// Método para reiniciar las estadisticas de los Pokemon, seteando la vida y la
	// mágia con vidaInicial y puntosMagiaInicial, que contienen los atributos del
	// constructor al crear el objeto
	public void reinicioStats() {
		setVida(vidaInicial);
		setPuntosMagia(puntosMagiaInicial);
	}

	// Método info que muestra la información del objeto Pokemon
	public String getInfo() {
		return "Nombre: " + nombre + "\nVida: " + vida + "\nMagia: " + puntosMagia + "\nNivel: " + exp
				+ "\nEvolucionado: " + evolucionado;
	}

	// Método para comprobar el ganador y comprobar si evoluciona
	public void ganador(Pokemon pokemon) {
		if (getVida() > 0 && pokemon.getVida() <= 0) {
			setExp(getExp() + 1);
			System.out.println("GANADOR: " + getNombre() + "\n");
		}
		if (evolucionado == false) {
			evoluciona();
		}
	}

}
