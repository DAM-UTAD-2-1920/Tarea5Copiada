package ejercicio;

import ejercicio.Bombo;

public class Presentador extends Thread {
	Bombo c;
	
	Presentador(Bombo c) {
		this.c = c;
	}
	
	public void run() {
		try {
			for (int i=0;i<c.TOTAL_BOMBO;i++) {
				Thread.sleep(2000);
				c.get();
			}
		} catch (Exception e) {
		}
	}
}
