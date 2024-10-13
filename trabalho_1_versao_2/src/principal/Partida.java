package principal;

import java.util.Arrays;
import java.util.Iterator;

import list.ArrayList;
import list.List;

public class Partida {
	
	private Jogador1 jogador1;
	private Jogador2 jogador2;
	private Mesa mesa;
	private MonteCompra monteCompra;
	private String[] cartas;
	private String resultado;
	
	public Partida() {
		this.jogador1 = null;
		this.jogador2 = null;
		this.mesa = null;
		this.monteCompra = null;
		this.cartas = null;
		this.resultado = "";
	}
	
	public Partida(Jogador1 jogador1, Jogador2 jogador2, Mesa mesa, MonteCompra monteCompra, String[] cartas, String resultado) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.mesa = mesa;
		this.monteCompra = monteCompra;
		this.cartas = cartas;
		this.resultado = resultado;
	}
	public Jogador1 getJogador1() {
		return jogador1;
	}
	public void setJogador1(Jogador1 jogador1) {
		this.jogador1 = jogador1;
	}
	public Jogador2 getJogador2() {
		return jogador2;
	}
	public void setJogador2(Jogador2 jogador2) {
		this.jogador2 = jogador2;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}	
	public MonteCompra getMonteCompra() {
		return monteCompra;
	}
	public void setMonteCompra(MonteCompra monteCompra) {
		this.monteCompra = monteCompra;
	}
	public String[] getCartas() {
		return cartas;
	}
	public void setCartas(String[] cartas) {
		this.cartas = cartas;
	}
	public String getResultado() {
		String vencedor = "";
		if (this.jogador1.getCartasColetadas().size() == this.jogador2.getCartasColetadas().size()) {
			vencedor = "Empate";
		} else if (this.jogador1.getCartasColetadas().size() > this.jogador2.getCartasColetadas().size()) {
			vencedor = "Jogador 1";
		} else {
			vencedor = "Jogador 2";
		}
		
		return this.jogador1.getCartasColetadas().size() + " " + this.jogador2.getCartasColetadas().size() + " " + vencedor;
	}
	
	
	
	@Override
	public String toString() {
		return "Partida [jogador1=" + jogador1 + ", jogador2=" + jogador2 + ", mesa=" + mesa + ", monteCompra="
				+ monteCompra + ", cartas=" + Arrays.toString(cartas) + ", resultado=" + resultado + "]";
	}
	
	private void distribuirCartas() {
		for (int i = 0; i < this.cartas.length; i++) {
			if (i < 4) {
				this.jogador1.getCartasMao().add(this.cartas[i]);
			} else if (i < 8) {
				this.jogador2.getCartasMao().add(this.cartas[i]);
			} else if (i < 12) {
				this.mesa.getCartas().addLast(this.cartas[i]);
			} else {
				this.monteCompra.getCartas().push(this.cartas[i]);
			}
		}
	}

	public void realizarPartida() {
		char extremidade = 0;
		this.distribuirCartas();
		while (!this.monteCompra.getCartas().isEmpty()) {

			//Movimenta Jogador 1
			if (!this.jogador1.getCartasMao().isEmpty()) {
				extremidade = this.realizarMovimento(this.jogador1);
				this.posicionarNovaCartaMesa(extremidade);				
			}
			
			// Movimenta Jogador 2
			if (!this.jogador2.getCartasMao().isEmpty()) {				//
				extremidade = this.realizarMovimento(this.jogador2);
				this.posicionarNovaCartaMesa(extremidade);
			}
		}
	}
	
	private char realizarMovimento(Jogador jogador) {
		char extremidadePosicionamento = 0;
		
		List<String> cartasClone = this.clonarCartasMesa();
		String carta = jogador.apresentarCarta(this.mesa.getCartas().first(), this.mesa.getCartas().last(), cartasClone);
		this.refreshCartasMesa(cartasClone);
		
		if (carta != null) {
			if (carta.equalsIgnoreCase(this.mesa.getCartas().first()) && carta.equalsIgnoreCase(this.mesa.getCartas().last())) {
				this.recolherCartas(jogador, 'D');
				extremidadePosicionamento = 'D';
			} else if (carta.equalsIgnoreCase(this.mesa.getCartas().first())) {
				this.recolherCartas(jogador, 'E');
				extremidadePosicionamento = 'E';
			} else if (carta.equalsIgnoreCase(this.mesa.getCartas().last())) {
				this.recolherCartas(jogador, 'D');
				extremidadePosicionamento = 'D';
			}			
		} else {
			String cartaDescarte = jogador.descartarCarta();
			char extremidade = jogador.escolherExtremidadeDescarte();
			switch (extremidade) {
				case 'E':
					this.mesa.getCartas().addFirst(cartaDescarte);
					extremidadePosicionamento = 'D';
					break;
				case 'D':
					this.mesa.getCartas().addLast(cartaDescarte);
					extremidadePosicionamento = 'E';
					break;
			}
		}
		
		//Comprando carta
		if (this.monteCompra.getCartas().top() != null) {
			jogador.receberCarta(this.monteCompra.getCartas().pop());			
		}
		return extremidadePosicionamento;
	}
	
	private void recolherCartas(Jogador jogador, char lado) {
		boolean recolher = true;
		while(recolher) {
			switch (lado) {
				case 'E':
					if (this.mesa.getCartas().first() != null) {
						jogador.getCartasColetadas().push(this.mesa.getCartas().removeFirst());
						if (this.mesa.getCartas().first() != null && !this.mesa.getCartas().first().equalsIgnoreCase(jogador.getCartasColetadas().top())) {
							recolher = false;
						}
					}
					else {
						recolher = false;
					}
					break;
				case 'D':
					if (this.mesa.getCartas().last() != null) {
						jogador.getCartasColetadas().push(this.mesa.getCartas().removeLast());
						if (this.mesa.getCartas().last() != null && !this.mesa.getCartas().last().equalsIgnoreCase(jogador.getCartasColetadas().top())) {
							recolher = false;
						}
					} else {
						recolher = false;
					}
					break;
			}
		}
	}
	
	private void posicionarNovaCartaMesa(char posicao) {
		if (this.monteCompra.getCartas().top() != null ) {
			if (this.monteCompra.getCartas() != null) {
				switch (posicao) {
				case 'E':
					this.mesa.getCartas().addFirst(this.monteCompra.getCartas().pop());
					break;
				case 'D':
					this.mesa.getCartas().addLast(this.monteCompra.getCartas().pop());
					break;
				}			
			}			
		}
	}
	
	private List<String> clonarCartasMesa() {
		List<String> cartasClone = new ArrayList<String>(); 
		int index = 0;
		while (!this.mesa.getCartas().isEmpty()) {
			cartasClone.add(index, this.mesa.getCartas().removeFirst());
			index++;
		}
		return cartasClone;
	}
	
	private void refreshCartasMesa(List<String> cartasClone) {
		for (int i = 0; i < cartasClone.size() ; i++) {
			this.mesa.getCartas().addLast(cartasClone.get(i));
		}
	}

}
