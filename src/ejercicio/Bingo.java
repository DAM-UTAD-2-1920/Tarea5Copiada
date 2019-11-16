package ejercicio;

import java.util.Scanner;

public class Bingo {
	static int numjugadores;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("<-------- COMIENZA EL BINGO -------->");
		System.out.println("¿CUANTOS JUGADORES VAN A JUGAR?");
		numjugadores = in.nextInt();
		Jugador[] jugadores = new Jugador[numjugadores];
		Bombo bombo = new Bombo();
		Presentador presentador = new Presentador(bombo);

		for (int i = 0; i < numjugadores; i++) {
			Jugador jugador = new Jugador(i, bombo);
			jugadores[i] = jugador;
			jugador.start();
		}

		presentador.start();

		for (int i = 0; i < numjugadores; i++) {
			try {
				jugadores[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			presentador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}