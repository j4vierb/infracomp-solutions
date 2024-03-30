package taller3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

public class Buffer {
	private List<String> buffer;
	private int size;
	
	public Buffer(int size) {
		this.size = size;
		this.buffer = new LinkedList<String>();
	}
	
	public synchronized boolean hasMessages() {
		return this.buffer.size() > 0;
	}
	
	public synchronized void insertMessage(String message) {
		while(this.buffer.size() == this.size) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.buffer.add(message);
		notify();
	}
	
	public synchronized String retrieveMessage() {
		while(this.buffer.size() == 0) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String message = this.buffer.remove(0);
		notify();
		
		return message;
	}
}
