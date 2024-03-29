package taller2.ejercicio2;

public class T extends Thread {
	public static GeneradorId gen;
	public Integer id;

	public T(GeneradorId gen) {
		this.gen = gen;
	}

	@Override
	public void run() {
		this.id = gen.darId();
		System.out.format("[+] Comenzar a buscar maximo en la fila %d\n", this.id);
	}
}
