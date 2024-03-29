package taller2.ejercicio2;

public class Main {
	public static void main(String []args) {
		GeneradorId gen = new GeneradorId();
		for(int i = 0; i < 10; i++) {
			T thread = new T(gen);
			thread.start();
		}
	}
}
