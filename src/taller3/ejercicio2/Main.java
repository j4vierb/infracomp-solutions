package taller3.ejercicio2;

public class Main {
	public static void main(String []args) {
		Buffer buffer = new Buffer(1);
		Productor productor = new Productor(0, buffer, 1);
		Consumidor consumidor = new Consumidor(1, buffer, 1);
		
		productor.start();
		consumidor.start();
	}
}
