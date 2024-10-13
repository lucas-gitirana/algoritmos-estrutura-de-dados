package principal;

import deque.ArrayDeque;

public class Mesa {
	private ArrayDeque<String> cartas;

	public Mesa() {
		this.cartas = new ArrayDeque<String>();
	}
	
	public Mesa(ArrayDeque<String> cartas) {
		this.cartas = cartas;
	}

	public ArrayDeque<String> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayDeque<String> cartas) {
		this.cartas = cartas;
	}

	@Override
	public String toString() {
		return "Mesa [cartas=" + cartas + "]";
	}
}
