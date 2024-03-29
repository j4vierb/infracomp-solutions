package taller2.ejercicio3;

public class Cliente extends Thread {
	private Pastel pastel;
	
	public Cliente(Pastel pastel) {
		this.pastel = pastel;
	}
	
	@Override
	public void run() {
		System.out.println("Inicia el cliente!");
		
		pastel.hacerPedido(1, 1, "Fresa", "Rojo");
		System.out.println("[Cliente] Ya configure el pastel!");
		
		synchronized(pastel) {
			System.out.println("[Cliente] Espero al pastelero!");
			try { pastel.wait(); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		System.out.println("[Cliente] Finaliza el proceso");
	}
}
