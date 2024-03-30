package taller3.ejercicio1;

public class Pasarela {
	//personas caminando hacia la izquierda
	private int personasIzquierdaDerecha;
	// personas caminando hacia la derecha
	private int personasDerechaIzquierda;

	public Pasarela() {
		this.personasDerechaIzquierda = 0;
		this.personasIzquierdaDerecha = 0;
	}

	public synchronized void entrar(int id, char direccion) {
		System.out.format("[Entrada] Entra persona %d en direccion %c\n", id, direccion);
		if(direccion == 'l') {
			while(personasDerechaIzquierda > 0) {
				try {
					System.out.format("[Dormir] La persona %d en direccion %c se durmio\n", id, direccion);
					wait();
				} catch(InterruptedException e) {}
			}
			
			personasIzquierdaDerecha++;
			System.out.format("[Izquierda - Derecha] Cantidad: %d\n", personasIzquierdaDerecha);
		} else if(direccion == 'r') {
			while(personasIzquierdaDerecha > 0) {
				synchronized(this) {
					try {
						System.out.format("[Dormir] La persona %d en direccion %c se durmio\n", id, direccion);
						wait();
					} catch(InterruptedException e) { e.printStackTrace(); }
				}
			}
			
			personasDerechaIzquierda++;
			System.out.format("[Derecha - Izquierda] Cantidad: %d\n", personasDerechaIzquierda);
		}
	}
	
	public void caminar() {
		try { Thread.sleep(1000); }
		catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public synchronized void salir(int id, char direccion) {
		System.err.format("[Salir] Sale persona %d en direccion %c\n", id, direccion);
		if(direccion == 'l')
			personasIzquierdaDerecha--;
		else if(direccion == 'r')
			personasDerechaIzquierda--;
		
		synchronized(this) {
			notifyAll();
		}
	}
}
