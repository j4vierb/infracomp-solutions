package atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * La clase AtomicInteger nos puede servir para generar los identificadores
 * de los procesos. Asimismo, como es una clase que trabaja de manera
 * atomica no existe la posibilidad de que otro Thread ingrese a modificar
 * el valor y se generen incosistencias.
 */
public class TestAtomicInteger extends Thread {
	private Integer id = 0;
	
	public TestAtomicInteger(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("My id is " + this.id);
	}
	
  /**
   * En este caso utilizamos la clase de AtomicInteger como
   * una clase para generar identificadores unicos
   */
	public static void main(String []args) {
		AtomicInteger genId = new AtomicInteger();
		for(Integer i = 0; i < 5; i++) {
			new TestAtomicInteger(genId.getAndAdd(1)).start();
		}
	}

}
