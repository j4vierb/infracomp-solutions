package taller2.ejercicio1;

public class Maximo {
  private Integer maximo;

  public Maximo() {
    this.maximo = -1;
  }

  /**
   * Este metodo trabaja en exclusión mutua
   * @param value
   * @return Booleano que indica si se actualizo el maximo
   */
  public synchronized void updateMaximo(Integer row, Integer value) {
    if(value > this.maximo) {
    	System.out.format("[>] Actualizado en %d: %d por %d\n", row, this.maximo, value);
      this.maximo = value;
    }
  }
}
