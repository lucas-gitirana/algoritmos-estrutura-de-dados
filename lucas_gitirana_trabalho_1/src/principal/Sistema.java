package principal;

import java.util.Scanner;

import deque.LinkedDeque;
import list.ArrayList;
import list.List;
import stack.ArrayStack;
import stack.Stack;
import utils.Point;

public class Sistema {
	
	//static List<String> cartasJog1 = new ArrayList<>();
	//static List<String> cartasJog2 = new ArrayList<>();
	static Stack<String> cartasMonte = new ArrayStack<>();  
	static LinkedDeque<String> cartasMesa = new LinkedDeque<>();
	
	static Jogador1 j1 = new Jogador1();
	static Jogador2 j2 = new Jogador2();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);			
		
		/* TESTE */
		//String entrada = s.nextLine();
		String entrada = "DelRey Santana Chevette Brasília 147 Monza Chevette Corcel Fusca Opala Santana Brasília DelRey Corcel Chevette Corcel Fusca Opala Corcel Opala Parati Monza Chevette Brasília 147 Santana 147 Monza Fusca Opala 147 Parati Fusca Corcel Fusca Monza 147 Parati Brasília Brasília Brasília DelRey Santana Parati Monza Santana Corcel Parati DelRey Chevette Santana Parati 147 Fusca DelRey Monza Chevette Opala DelRey Opala";
		String[] cartas = entrada.split(" ");
		
		for (int i = 0; i < cartas.length; i++) {
			if (i < 4) j1.getCartas().add(i, cartas[i]);
			else if (i < 8) j2.getCartas().add((i - 4), cartas[i]);
			else if (i < 12) cartasMesa.addLast(cartas[i]);
			else cartasMonte.push(cartas[i]);
		}
		
		System.out.println("J1: " +j1.getCartas().toString());
		System.out.println("J2: " +j2.getCartas().toString());
		System.out.println("Mesa: " +cartasMesa.toString());
		System.out.println("Monte: " +cartasMonte.toString());
		
		
		/*Começando jogo - J1*/
		System.out.println("J1 escolha! ");
		int index  = j1.escolherCarta(cartasMesa); 
		if (index >= 0) {
			System.out.println("VOCÊ TEM! " +j1.getCartas().get(index));
			System.out.println("J1 recolha as cartas!");
			j1.recolherCartas(cartasMesa, j1.escolherCarta(cartasMesa));
		} else {
			System.out.println("J1 VOCÊ NÃO TEM!");
			System.out.println("J1 entregue a primeira carta!");
			j1.entregarCarta(cartasMesa);
		}
		System.out.println("J1: " +j1.getCartas().toString());
		System.out.println("Mesa: " +cartasMesa.toString());
		
		System.out.println("J1 compre do monte!");
		System.out.println("Monte: " + cartasMonte.toString());
		j1.comprarCarta(cartasMonte);
		System.out.println("J1: " +j1.getCartas().toString());
		System.out.println("Monte: " + cartasMonte.toString());
		
		/* Continuando - J2 */
		System.out.println("J2 escolha! ");
		index = j2.escolherCarta(cartasMesa); 
		if (index >= 0) {
			System.out.println("VOCÊ TEM! " +j2.getCartas().get(index));
			//System.out.println("J1 recolha as cartas!");
			//j1.recolherCartas(cartasMesa, j1.escolherCarta(cartasMesa));
		} else {
			System.out.println("J2 VOCÊ NÃO TEM!");
			System.out.println("J1 entregue a carta!");
			j2.entregarCarta(cartasMesa);
		}
		System.out.println("J2: " +j2.getCartas().toString());
		System.out.println("Mesa: " +cartasMesa.toString());
		
		System.out.println("J2 compre do monte!");
		System.out.println("Monte: " + cartasMonte.toString());
		j2.comprarCarta(cartasMonte);
		System.out.println("J2: " +j2.getCartas().toString());
		System.out.println("Monte: " + cartasMonte.toString());
		
	}

}
