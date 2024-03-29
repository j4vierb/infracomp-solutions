package taller2.ejercicio3;

public class Main {
	public static void main(String []args) {
		Pastel pastel = new Pastel();
		
		Cliente cliente = new Cliente(pastel);
		Pastelero pastelero = new Pastelero(pastel);
		
		cliente.start();
		pastelero.start();
	}
}
