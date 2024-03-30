package taller3.ejercicio1;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static void main(String []args) {
		Pasarela pasarela = new Pasarela();
		
		for(int i = 0; i < 6; i++) {
			int num = ThreadLocalRandom.current().nextInt(0, 10);
			// l: va de izquierda a derecha
			// r: va de derecha a izquierda
			Persona persona = new Persona(i, pasarela, num > 5 ? 'l' : 'r');
			persona.start();
		}
	}
}
