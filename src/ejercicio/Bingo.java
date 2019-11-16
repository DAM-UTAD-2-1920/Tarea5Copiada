package ejercicio;

import java.util.Scanner;
import ejercicio.Bombo;
import ejercicio.Jugador;
import ejercicio.Presentador;

public class Bingo {
	static Scanner sc = new Scanner(System.in);
	static int jugadores;

	public static void main(String[] args) {
		Thread jugador;
		Bombo bombo = new Bombo();
		System.out.println("comienza");
		System.out.println("introduce número de jugadores:");
		jugadores = sc.nextInt();

		for (int i = 1; i <= jugadores; i++) {
			jugador = new Jugador(i, bombo);
			System.out.println("jugador " + i + " listo");
			jugador.start();
		}
		Thread presentador = new Presentador(bombo);
		presentador.start();
	}
}