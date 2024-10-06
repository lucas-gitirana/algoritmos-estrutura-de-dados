package principal;

import deque.LinkedDeque;
import list.ArrayList;
import list.List;
import stack.Stack;

public class Jogador2 {
	private List<String> cartas;	

	public Jogador2() {
		this.cartas = new ArrayList<>();
	}
	
	public Jogador2(List<String> cartas) {		
		this.cartas = cartas;
	}

	public List<String> getCartas() {
		return cartas;
	}

	public void setCartas(List<String> cartas) {
		this.cartas = cartas;
	}
	
	public int escolherCarta(LinkedDeque<String> cartasMesa) {
		String cartaEsquerda = cartasMesa.first();
		String cartaDireita = cartasMesa.last();
		int countEsquerda = 0;
		int countDireita = 0;
		int indexEsquerda = -1;
		int indexDireita = -1;		
		
		//Transformando o deque em arraylista para conseguir percorrer ele sem alterar seus valores
		ArrayList<String> cartasMesaTemp = new ArrayList<>();
		while (!cartasMesa.isEmpty()) {
			cartasMesaTemp.add(cartasMesa.removeFirst());
		}
		
		//Percorrendo cada carta da mão para verificar se ela é igual ou não a uma carta da esquerda ou direita
		for (int i = 0; i < this.getCartas().size(); i++) {
			if (this.getCartas().get(i).equalsIgnoreCase(cartaEsquerda) && countEsquerda == 0) {
				// Se a carta é igual à da esquerda, vamos contar quantas conseguimos recolher
				countEsquerda++;
				indexEsquerda = i;
				for (int j = 1; j < cartasMesaTemp.size(); j++) {
					if (cartasMesaTemp.get(j).equalsIgnoreCase(cartaEsquerda)) countEsquerda++;
					else break;
				}
			}
			
			if (this.getCartas().get(i).equalsIgnoreCase(cartaDireita) && countDireita == 0) {
				// Se a carta é igual à da direita, vamos contar quantas conseguimos recolher
				countDireita++;
				indexDireita = i;
				for (int j = cartasMesaTemp.size() - 2; j >= 0; j--) {
					if (cartasMesaTemp.get(j).equalsIgnoreCase(cartaDireita)) countDireita++;
					else break;
				}
			}
			
			if (countEsquerda > 0 && countDireita > 0) {
				break;
			}
		}
		
		//Transformando o arraylist novamente em deque para devolver as cartas à mesa
		for (int i = 0; i < cartasMesaTemp.size(); i++) {
			cartasMesa.addLast(cartasMesaTemp.get(i));
		}
		cartasMesaTemp = null;
		
		if (countEsquerda > countDireita) {
			return indexEsquerda;
		} else if (countEsquerda != countDireita) {
			return indexDireita;
		} else {
			return (indexEsquerda <= indexDireita) ? indexEsquerda : indexDireita;
		}
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
		cartasMesa.addLast(this.getCartas().remove(this.getCartas().size() - 1));
	}
	
	public void comprarCarta(Stack<String> cartasMonte) {
		this.getCartas().add(this.getCartas().size(), cartasMonte.pop());
	}
}
