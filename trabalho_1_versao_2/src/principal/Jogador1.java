package principal;

import java.util.LinkedList;

import list.ArrayList;
import list.List;
import stack.ArrayStack;

public class Jogador1 extends Jogador{

	public Jogador1() {
		super();
	}

	public Jogador1(LinkedList<String> cartasMao, ArrayStack<String> cartasColetadas) {
		super(cartasMao, cartasColetadas);
	}

	@Override
	public String apresentarCarta(String cartaDireita, String cartaEsquerda, List<String> cartasMesa) {
		cartaDireita = cartasMesa.get(cartasMesa.size() - 1);
		cartaEsquerda = cartasMesa.get(0);
		
		for (int i = 0; i < this.cartasMao.size(); i++) {
			if (this.cartasMao.get(i).equalsIgnoreCase(cartaEsquerda) || 
				this.cartasMao.get(i).equalsIgnoreCase(cartaDireita)) {
				return this.cartasMao.get(i);
			}
		}
		return null;
	}

	@Override
	public char escolherExtremidadeDescarte() {
		return 'E';
	}

	@Override
	public String descartarCarta() {
		return this.cartasMao.remove(0);
	}

	@Override
	public void receberCarta(String carta) {
		this.cartasMao.add(this.cartasMao.size(), carta);
	}
}
