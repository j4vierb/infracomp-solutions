package taller2.ejercicio1;

public class Main {
  private Integer ROWS = 4;
  private Integer COLS = 4;
  private int[][] matriz;
  
  public Main() {
  	this.matriz = this.genMatriz(this.ROWS, this.COLS);
  }
  
  public int[][] genMatriz(int rows, int cols) {
  	int matriz[][] = new int[rows][cols];
  	
  	for(int i = 0; i < rows; i++) {
  		for(int j = 0; j < cols; j++) {
  			matriz[i][j] = i * j;
  		}
  	}
  	
  	return matriz;
  }
  
  public Integer getRows() { return this.ROWS; }
  public Integer getCols() { return this.COLS; }
  public int[][] getMatr() { return this.matriz; }

  public static void main(String []args) {
  	Main main = new Main();
    Maximo maximo = new Maximo();
    
    for(int row = 0; row < main.getRows(); row++) {
      T thread = new T(row, main.getCols(), main.getMatr(), maximo);
      thread.start();
    }
  }
}
