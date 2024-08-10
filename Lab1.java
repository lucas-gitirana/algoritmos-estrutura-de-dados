package algoritmos;

public class Lab1 {

	public static void main(String[] args) {
		//Laboratório 01
		
		String[] vetor = {"flower", "flow", "flight"};
		//String[] vetor = {"cadete", "cadeira", "academia"};
		
		String resultado = "";
		boolean isEqual = true;
		for(int i = 0; i < vetor[0].length(); i++) {
			for(int j = 1; j < vetor.length; j++){
				if(vetor[0].charAt(i) != vetor[j].charAt(i)) {
					isEqual = false;
				}
			}
			if(isEqual){
				resultado += vetor[0].charAt(i);
			} else {
				break;
			}
		}
		
		//Apresentação
		String vetorString = "";
		for(String p : vetor) {
			vetorString += p + " ";
		}
		System.out.println("Vetor: [ " +vetorString+ "]\nResultado: " + resultado);
	}
}
