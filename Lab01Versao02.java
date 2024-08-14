package lab01versao02;

import java.util.Random;
import java.util.Scanner;

public class Lab01Versao02 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ordem: ");
		int n = s.nextInt();
		
		Random gerador = new Random();
		
		String base = "ABDCADBACD";
		for (int i = 1; i <= (2^n); i++) {
			for (int x = 1; x <= 3; x++) {
				int index = gerador.nextInt(base.length());
			}
		}
	
	}
	
	
}
