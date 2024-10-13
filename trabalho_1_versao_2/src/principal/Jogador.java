package principal;

import java.util.LinkedList;

import list.ArrayList;
import list.List;
import stack.ArrayStack;

public abstract class Jogador {
	protected LinkedList<String> cartasMao;
	protected ArrayStack<String> cartasColetadas;
	
	public Jogador() {
		this.cartasMao = new LinkedList<String>();
		this.cartasColetadas = new ArrayStack<String>();
	}
	
	public Jogador(LinkedList<String> cartasMao, ArrayStack<String> cartasColetadas) {
		this.cartasMao = cartasMao;
		this.cartasColetadas = cartasColetadas;
	}
	
	public LinkedList<String> getCartasMao() {
		return cartasMao;
	}
	public void setCartasMao(LinkedList<String> cartasMao) {
		this.cartasMao = cartasMao;
	}
	public ArrayStack<String> getCartasColetadas() {
		return cartasColetadas;
	}
	public void setCartasColetadas(ArrayStack<String> cartasColetadas) {
		this.cartasColetadas = cartasColetadas;
	}
	
	public abstract String apresentarCarta(String cartaDireita, String cartaEsquerda, List<String> cartasMesa);
	public abstract char escolherExtremidadeDescarte();
	public abstract String descartarCarta();
	public abstract void receberCarta(String carta); 

	@Override
	public String toString() {
		return "Jogador [cartasMao=" + cartasMao + ", cartasColetadas=" + cartasColetadas + "]";
	}
	
	
}
