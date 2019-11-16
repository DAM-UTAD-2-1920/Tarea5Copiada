package ejercicio;

import java.util.HashSet;

class Bombo {
	int numvecJugado = 0;
	int hayBola = 0;
	HashSet<Integer> bombo; 
	Integer ultNumero;
	Jugador jug;
	final int TOTAL_BOMBO = 10; 
	int aux = Bingo.numjugadores;

	public Bombo() {
		bombo = new HashSet<Integer>();
	}

	public synchronized void sacarNum() {
		while (hayBola != 0 /* && numvecJugado!= aux */) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sacarNum2();
		imprimirBombo();
		hayBola++;
		notify();

	}

	public Integer sacarNum2() {
		Integer bolita = 0;
		int cantidadBolas = bombo.size();
		if (cantidadBolas < TOTAL_BOMBO) {
			do {
				ultNumero = (int) Math.floor(Math.random() * TOTAL_BOMBO) + 1;
				bombo.add(ultNumero);
				bolita = ultNumero;
			} while (cantidadBolas == bombo.size());
			System.out.println("Ha salido el número: " + ultNumero);
		} else
			System.out.println("Ya han salido todas las bolas");
		return bolita;
	}

	public void imprimirBombo() {
		System.out.print("Bolas sacadas hasta el momento: ");
		for (Integer integer : bombo)
			System.out.print(integer + " ");
		System.out.println();
	}
	
	public synchronized void consultar() {
		while (hayBola == 0 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numvecJugado++;
		hayBola--;
		notify();
	}
}