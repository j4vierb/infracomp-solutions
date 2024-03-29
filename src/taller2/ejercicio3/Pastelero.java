package taller2.ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class Pastelero extends Thread {
	private Pastel pastel;

	public Pastelero(Pastel pastel) {
		this.pastel = pastel;
	}

	@Override
	public void run() {
		System.out.println("Inicia el pastelero!");

		while(!pastel.consultarEstadoPedido()) {
			System.out.println("[Pastelero] No se ha configurado el pastel");
			try { Thread.sleep(5000); }
			catch(Exception e) {}
		}
		
		int time = ThreadLocalRandom.current().nextInt(5, 15);
		System.out.format("[Pastelero] Se inicia a hacer el pastel, esperar %d s\n", time);
		try { Thread.sleep(time * 1000); }
		catch(Exception e) {}
		
		System.out.println("[Pastelero] Ya termino el pastel");
		synchronized(pastel) {
			pastel.notify();
		}
		
		System.out.println("[Pastelero] Finaliza el proceso");
	}
}
