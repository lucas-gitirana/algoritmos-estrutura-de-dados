package principal;

import stack.ArrayStack;

public class MonteCompra {
	private ArrayStack<String> cartas;
	
	public MonteCompra() {
		this.cartas = new ArrayStack<String>();
	}
	
	public MonteCompra(ArrayStack<String> cartas) {
		this.cartas = cartas;
	}

	public ArrayStack<String> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayStack<String> cartas) {
		this.cartas = cartas;
	}

	@Override
	public String toString() {
		return "MonteCompra [cartas=" + cartas + "]";
	}
	
}
