package taller2.ejercicio1;

public class T extends Thread {
  private Integer row;
  private Integer col;
  private int matriz[][];
  private Maximo maximo;
  private Integer maximoLocal;

  public T(Integer row, Integer col, int matriz[][], Maximo maximo) {
    this.row = row;
    this.col = col;
    this.matriz = matriz;
    this.maximo = maximo;
    this.maximoLocal = -1;
  }

  @Override
  public void run() {
    System.out.println("[+] Buscando en " + this.row);

    for(int col = 0; col < this.col; col++) {
      if(matriz[this.row][col] > this.maximoLocal)
        this.maximoLocal = matriz[this.row][col];
    }

    maximo.updateMaximo(this.row, maximoLocal);
  }
 }
