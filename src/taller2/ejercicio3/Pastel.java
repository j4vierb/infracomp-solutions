package taller2.ejercicio3;

public class Pastel {
	private int alto;
	private int radio;
	private String sabor;
	private String color;
	
	private boolean clienteConfiguro;

	public Pastel() {
		this.clienteConfiguro = false;
	}
	
	public void hacerPedido(int alto, int radio, String sabor, String color) {
		this.alto = alto;
		this.radio = radio;
		this.sabor = sabor;
		this.color = color;
		this.clienteConfiguro = true;
	}
	
	public void consultarDetallesPedido() {
		System.out.format("[-] alto: %d\n[-] radio: %d\n[-] sabor: %d\n[-] color: %d\n", alto, radio, sabor, color);
	}
	
	/**
	 * Metodo para consultar si el cliente ya configuro el pastel
	 */
	public boolean consultarEstadoPedido() {
		return this.clienteConfiguro;
	}
}
