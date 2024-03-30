package taller3.ejercicio2;

public class Productor extends Thread {
	private int id;
	private Buffer buffer;
	private int times;
	
	public Productor(int id, Buffer buffer, int times) {
		this.id = id;
		this.buffer = buffer;
		this.times = times;
	}
	
	private void sendMessage(int i) {
		this.buffer.insertMessage(
			String.format("El thread productor %d saluda con el mensaje %d de %d", this.id, i, this.times)			
		);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < this.times; i++) {
			this.sendMessage(i);
		}
	}
}
