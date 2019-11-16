package ejercicio;

import java.util.HashSet;

class Jugador extends Thread {
	final int TOTAL_CARTON = 5;
	final int TOTAL_BOMBO = 10;
	int idJugador;
	HashSet<Integer> carton;
	Bombo b;

	public Jugador(int idJugador, Bombo b) {
		this.b = b;
		this.idJugador = idJugador;
		carton = new HashSet<Integer>();
		while (carton.size() < TOTAL_CARTON)
			carton.add((int) Math.floor(Math.random() * TOTAL_BOMBO) + 1);
		System.out.println(" EL JUGADOR " + idJugador + " TIENE EL CARTON " + carton);
	}

	public void imprimeCarton() {
		System.out.print("Pendientes jugador " + idJugador + ": ");
		for (Integer integer : carton)
			System.out.print(integer + " ");
		System.out.println();
	}

	public void run() {
		while (carton.size() > 0) {
			b.consultar();
			System.out.println("El jugador  " + idJugador + "  va a jugar ");
			tacharNum(b.ultNumero);
			for (Integer integer : b.bombo) {
				carton.remove(integer);
			}
			System.out.println("El jugador  " + idJugador + "  ha jugado ");
			imprimeCarton();
		}
		System.out.println("<---------------BINGOOOOOOOO---------------> \n" + "El jugador " + idJugador
				+ " ha cantado BINGO! \n" + "El jugador " + idJugador + " es el ganador. ¡¡¡ENHORABUENA!!!");
		try {
			System.exit(0);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void tacharNum(Integer numero) {
		carton.remove(numero);
	}
	
}