package ejercicio;

import java.util.HashSet;

public class Jugador extends Thread {
	final int TOTAL_CARTON = 5;
	final int TOTAL_BOMBO = 10;
	int id;
	HashSet<Integer> carton;
	Bombo b;

	Jugador(int id, Bombo b) {
		this.b = b;
		this.id = id;
		carton = new HashSet<Integer>();
		while (carton.size() < TOTAL_CARTON)
			carton.add((int) Math.floor(Math.random() * TOTAL_BOMBO) + 1);
		System.out.println("jugador: " + id + " tiene: " + carton);
	}

	void printC() {
		System.out.print("a jugador " + id + " le faltan: ");
		for (Integer integer : carton)
			System.out.print(integer + " ");
		System.out.println();
	}
	
	public void run() {
		while (carton.size() > 0) {
			b.query();
			System.out.println("jugador " + id + " tiene su turno");
			lessN(b.last);
			for (Integer integer : b.hash) {
				carton.remove(integer);
			}
			System.out.println("jugador " + id + " ha jugado ");
			printC();
		}
		System.out.println("jugador: " + id + " consigue el bingo");

		try {
			finalize();
			System.exit(0);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	void lessN(Integer numero) {
		carton.remove(numero);
	}
}
