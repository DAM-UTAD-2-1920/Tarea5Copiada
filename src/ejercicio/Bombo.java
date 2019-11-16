package ejercicio;

import java.util.HashSet;

public class Bombo {
	int veces = 0;
	int bola = 0;
	HashSet<Integer> hash;
	Integer last;
	Jugador jugador;
	final int TOTAL_BOMBO = 10;
	int aux = Bingo.jugadores;

	Bombo() {
		hash = new HashSet<Integer>();
	}

	synchronized void get() {
		while (bola != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		get2();
		printB();
		bola++;
		notifyAll();
	}

	Integer get2() {
		Integer bola = 0;
		int cant = hash.size();
		if (cant < TOTAL_BOMBO) {
			do {
				last = (int) Math.floor(Math.random() * TOTAL_BOMBO) + 1;
				hash.add(last);
				bola = last;
			} while (cant == hash.size());
			System.out.println("sale el número: " + last);
		} else
			System.out.println("han salido todas las bolas ya");
		return bola;
	}

	void printB() {
		System.out.print("bolas fuera: ");
		for (Integer integer : hash)
			System.out.print(integer + " ");
		System.out.println();
	}

	synchronized void query() {
		while (bola == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		veces++;
		bola--;
		notify();
	}
}
