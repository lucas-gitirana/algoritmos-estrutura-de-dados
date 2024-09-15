package resolucoes;

import java.util.Scanner;

import stack.ArrayStack;
import stack.Stack;

public class Lab03 {
	
	static Stack<Character> stack;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Número de casos de teste: ");
		int casos = s.nextInt();
		String[] sequencias = new String[casos];
		
		for (int i = 0; i < casos; i++) {
			System.out.println("Sequência " +(i+1)+ ":");
			sequencias[i] = s.next();
		}
		
		int countMaior;
		int countMenor;
		for (String sequencia : sequencias) {
			stack = new ArrayStack<Character>();
			countMaior = 0;
			countMenor = 0;
			
			for (int i = 0; i < sequencia.length(); i++) {
				if (sequencia.charAt(i) != '.') {
					stack.push(sequencia.charAt(i));
				}
			}
			
			while (!stack.isEmpty()) {
				if (stack.top() == '>') {
					countMaior++;
					stack.pop();
				} else if (stack.top() == '<') {
					countMenor++;
					stack.pop();
				}
			}
			
			if (countMaior == countMenor) {
				System.out.println(countMaior);
			} else if (countMaior > countMenor && countMenor != 0) {
				System.out.println(countMenor);				
			} else if (countMaior != 0) {
				System.out.println(countMaior);				
			}
		}

	}

}
