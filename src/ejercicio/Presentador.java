package ejercicio;

import ejercicio.Bombo;

class Presentador extends Thread {
	private Bombo bombo;

	public Presentador(Bombo bombo) {
		this.bombo = bombo;
	}

	public void run() {
		try {
			for (int i = 0; i < bombo.TOTAL_BOMBO; i++) {
				Thread.sleep(1000);
				bombo.sacarNum();
			}
		} catch (Exception e) {
		}
	}
}