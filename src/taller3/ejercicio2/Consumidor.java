package taller3.ejercicio2;

public class Consumidor extends Thread {
	private int id;
	private Buffer buffer;
	private int times;
	
	public Consumidor(int id, Buffer buffer, int times) {
		this.id = id;
		this.buffer = buffer;
		this.times = times;
	}
	
	private void printMessage(String message) {
		String prot = "El consumidor %d recupero el siguiente mensaje: %s";
		System.out.println(String.format(prot, this.id, message));
	}
	
	@Override
	public void run() {
		while(this.buffer.hasMessages() && times-- > 0) {
			String message = this.buffer.retrieveMessage();
			if(message == null) return;
			this.printMessage(message);
		}
	}
}
