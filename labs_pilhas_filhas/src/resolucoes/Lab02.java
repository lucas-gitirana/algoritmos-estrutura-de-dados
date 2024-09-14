package resolucoes;

import java.util.Scanner;

import stack.ArrayStack;
import stack.Stack;

public class Lab02 {
	
	static Stack<Integer> stack = new ArrayStack<>();

	public static void main(String[] args) {
		String[] sequencia = {"5","2","C","D","+"};
		//String[] sequencia = {"5","-2","4","C","D","9","+","+"};
		//String[] sequencia = {"1","C"};
		
		for (int i = 0; i < sequencia.length; i++) {
			switch(sequencia[i].toUpperCase().charAt(0)) {
				case '+':
					int p1 = stack.pop();
					int p2 = stack.top();
					stack.push(p1);
					stack.push(p1+p2);
					break;
				case 'D':
					stack.push(stack.top()*2);
					break;
				case 'C':
					stack.pop();
					break;
				default:
					stack.push(Integer.parseInt(sequencia[i]));
					break;
			}
		}
		
		int pontuacao = 0;
		while (!stack.isEmpty()) {
			pontuacao += stack.pop();
		}
		
		System.out.println("Pontuação final: " + pontuacao);

	}

}
