package principal;

import java.util.Iterator;

import deque.LinkedDeque;
import list.ArrayList;
import list.List;
import stack.Stack;

public class Jogador1 {
	private List<String> cartas;	

	public Jogador1() {
		this.cartas = new ArrayList<>();
	}
	
	public Jogador1(List<String> cartas) {		
		this.cartas = cartas;
	}

	public List<String> getCartas() {
		return cartas;
	}

	public void setCartas(List<String> cartas) {
		this.cartas = cartas;
	}
	
	public int escolherCarta(LinkedDeque<String> cartasMesa) {
		for (int i = 0; i < cartas.size(); i++) {
			if (cartasMesa.first().equalsIgnoreCase(this.getCartas().get(i)) || cartasMesa.last().equalsIgnoreCase(this.getCartas().get(i))) 			
				return i; 
		}
		return -1;
	}
	
	public void recolherCartas(LinkedDeque<String> cartasMesa, int indexCartaMao) {
		boolean recolher = true;
		while (recolher) {
			if (cartasMesa.last().equalsIgnoreCase(this.getCartas().get(indexCartaMao))) {
				this.getCartas().add(this.getCartas().size(), cartasMesa.removeLast());
			} else if (cartasMesa.first().equalsIgnoreCase(this.getCartas().get(indexCartaMao))) {
				this.getCartas().add(this.getCartas().size(), cartasMesa.removeFirst());
			} else {
				recolher = false;
			}
		}
	}
	
	public void entregarCarta(LinkedDeque<String> cartasMesa) {
		cartasMesa.addFirst(this.getCartas().remove(0));
	}
	
	public void comprarCarta(Stack<String> cartasMonte) {
		this.getCartas().add(this.getCartas().size(), cartasMonte.pop());
	}
	
	
}
