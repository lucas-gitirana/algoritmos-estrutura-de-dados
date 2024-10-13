package stack;

import utils.Point;

public class Exercício {
	
	static Stack<Point> stack1 = new ArrayStack<>();
	static Stack<Point> stack2 = new ArrayStack<>();
	//static Stack<Point> stack = new LinkedStack<>();

	public static void main(String[] args) {
		System.out.println("Empilhando quatro elementos...");
		stack1.push(new Point(1, -1));
		stack1.push(new Point(0, 6));
		stack2.push(new Point(9, 5));
		stack2.push(new Point(-3, 8));

		/*System.out.println("Pilha: " + stack.toString());
		System.out.println("Empilhando um elemento: " + stack.pop().toString());
		System.out.println("Desempilhando outro elemento: " + stack.top().toString());
		System.out.println("Pilha: " + stack.toString());
		System.out.println("Tamanho: " + stack.size());
		System.out.println("Vazia? " + stack.isEmpty());
		
		System.out.println("Desempilhando três elementos...");
		stack.pop();
		stack.pop();
		stack.pop();

		System.out.println("Vazia? " + stack.isEmpty());*/
		
		//6.4.
		//stack1.transfer((ArrayStack<Point>) stack1, (ArrayStack<Point>) stack2);

	}
	
	public void transfer(ArrayStack<Point> S, ArrayStack<Point> T) {
		while(!S.isEmpty()) {
			T.push(S.pop());
		}
	}
	
	public void limpaPilha(ArrayStack<Point> S) {
		if (!S.isEmpty()) {
			S.pop();
			limpaPilha(S);
		}
	}

}
