package taller2.ejercicio2;

public class GeneradorId {
	private Integer id;

	public GeneradorId() {
		this.id = 0;
	}

	public synchronized int darId() {
		return id++;
	}
}
