package principal;

import java.util.LinkedList;

import list.ArrayList;
import list.List;
import stack.ArrayStack;

public class Jogador2 extends Jogador{

	public Jogador2() {
		super();
	}

	public Jogador2(LinkedList<String> cartasMao, ArrayStack<String> cartasColetadas) {
		super(cartasMao, cartasColetadas);
	}

	@Override
	public String apresentarCarta(String cartaDireita, String cartaEsquerda, List<String> cartasMesa) {
		boolean possuiCartaNaDireta = false;
		boolean possuiCartaNaEsquerda = false;
		
		String cartaEscolhidaDireita = "";
		String cartaEscolhidaEsquerda = "";
		
		for (int i = 0; i < this.cartasMao.size(); i++) {
			if (this.cartasMao.get(i).equalsIgnoreCase(cartasMesa.get(0))) {
				possuiCartaNaEsquerda = true;
				cartaEscolhidaEsquerda = this.cartasMao.get(i);
				
			}
			if (this.cartasMao.get(i).equalsIgnoreCase(cartasMesa.get(cartasMesa.size() - 1))) {
				possuiCartaNaDireta = true;
				cartaEscolhidaDireita = this.cartasMao.get(i); 
			}
		}
		
		int countDireita = 0;
		int countEsquerda = 0;
		
		if (possuiCartaNaDireta) {
			for (int i = (cartasMesa.size() - 1); i >= 0; i--) {
				if (cartaEscolhidaDireita.equalsIgnoreCase(cartasMesa.get(i))) {
					countDireita++;
				} else {
					break;
				}
			}
		}
		if (possuiCartaNaEsquerda) {
			for (int i = 0; i < cartasMesa.size(); i++) {
				if (cartaEscolhidaEsquerda.equalsIgnoreCase(cartasMesa.get(i))) {
					countEsquerda++;
				} else {
					break;
				}
			}
		}
		
		if (countDireita == 0 && countEsquerda == 0) {
			return null;
		} else if (countDireita == countEsquerda) {
			for (int i = 0; i < this.cartasMao.size(); i++) {
				if (this.cartasMao.get(i).equalsIgnoreCase(cartaEscolhidaDireita) ||
					this.cartasMao.get(i).equalsIgnoreCase(cartaEscolhidaEsquerda)) {
					return this.cartasMao.get(i);
				}
			}
			return null;
		} else {
			if (countDireita > countEsquerda) {
				return cartaEscolhidaDireita;
			} else {
				return cartaEscolhidaEsquerda;
			}
		}
	}

	@Override
	public char escolherExtremidadeDescarte() {
		return 'D';
	}

	@Override
	public String descartarCarta() {
		return this.cartasMao.remove(this.cartasMao.size() - 1);
	}

	@Override
	public void receberCarta(String carta) {
		this.cartasMao.add(this.cartasMao.size(), carta);
	}

	
	
	
}
