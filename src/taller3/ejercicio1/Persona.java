package taller3.ejercicio1;

public class Persona extends Thread {
	private char direccion;
	private Pasarela pasarela;
	private int id;
	
	@Override
	public void run() {
		pasarela.entrar(id, direccion);
		pasarela.caminar();
		pasarela.salir(id, direccion);
	}
	
	public Persona(int id, Pasarela pasarela, char direccion) {
		this.id = id;
		this.pasarela = pasarela;
		this.direccion = direccion;
	}
}
