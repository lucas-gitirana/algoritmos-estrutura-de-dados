package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sistema {
	
	static Partida partida;

	public static void main(String[] args) {
		if (args.length < 1) {
            //System.err.println("Forneça o nome do arquivo de entrada.");
            //return;
        }
		
        //String fileName = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader("src\\principal\\partidas.txt"))) {
            String line;
            var i = 0;
            while ((line = br.readLine()) != null) {
            	i++;
            	
            	Partida partida = new Partida();
            	Jogador1 jogador1 = new Jogador1();
            	Jogador2 jogador2 = new Jogador2();
            	Mesa mesa = new Mesa();
            	MonteCompra monteCompra = new MonteCompra();
            	String[] cartas = line.split(" ");
            	
            	partida.setJogador1(jogador1);
            	partida.setJogador2(jogador2);
            	partida.setMesa(mesa);
            	partida.setMonteCompra(monteCompra);
            	partida.setCartas(cartas);
            	
            	partida.realizarPartida();
            	
            	System.out.println(partida.toString());
            	System.out.println(partida.getResultado());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

	}

}
