package batalhanaval;
import batalhanaval.util.*;

import java.util.Random;
import java.util.Scanner;

public class Metodos {
	public static void jogo() {
		Random aleatorio = new Random();
		Scanner leia = new Scanner(System.in);
		String campoReal[][] = {{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"},{"🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊","🌊"}};
		String campoVisual[][] = {{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"},{"🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦","🟦"}};
		int chances = 3, aLinha, aColuna, pontuacao = 0;
		
		for(int i = 0; i < 35; i++) {
			int x = aleatorio.nextInt(10);
			int y = aleatorio.nextInt(10);
		
			if(campoReal[x][y].equals("🌊")) {
				campoReal[x][y] = "⛵";
			}else {
				do {
					x = aleatorio.nextInt(10);
					y = aleatorio.nextInt(10);
				}while(!campoReal[x][y].equals("🌊"));
				campoReal[x][y] = "⛵";
			}
		}
		
		
		while(chances > 0) {
			System.out.println(" 0   1   2   3  4  ⠀5   6   7   8  9");
			for(int linha= 0; linha < campoVisual.length; linha++) {
				for(int coluna = 0; coluna < campoVisual.length; coluna++) {
					System.out.print(Cores.TEXT_BLUE_BRIGHT+"["+ campoVisual[linha][coluna] +"]"+Cores.TEXT_RESET);
				}
				System.out.print(" "+linha);
				System.out.println();
			}
			
			System.out.println();
			
			System.out.print("Coluna de ataque: ");
			aColuna = leia.nextInt();
			System.out.print("Linha de ataque: ");
			aLinha = leia.nextInt();
			
			if((aLinha > 9 && aColuna > 9) || (aLinha < 0 && aColuna < 0)) {
				do {
					System.out.println("\nDIGITE UMA CORDENADA VÁLIDA\n");
					System.out.print("Linha de ataque: ");
					aLinha = leia.nextInt();
					System.out.print("Coluna de ataque: ");
					aColuna = leia.nextInt();
				}while((aLinha > 4 && aColuna > 4) || (aLinha < 0 && aColuna < 0));
			}
			
			if(campoReal[aLinha][aColuna].equals("⛵")) {
				if(campoVisual[aLinha][aColuna].equals("⛵")) {
					System.out.println("Você ja atacou essa posição");
				}else {
					campoVisual[aLinha][aColuna] = campoReal[aLinha][aColuna];
					System.out.println("""
							
							|----------------------|
							|Você afundou um barco!|
							|----------------------|
							""");
					chances--;
					pontuacao++;
				}
			}else {
				campoVisual[aLinha][aColuna] = campoReal[aLinha][aColuna];
				System.out.println("""
						
						|--------------------------|
						|Seu ataque atingiu a água!|
						|--------------------------|
						""");
				chances--;
			}
			
		}
		
		System.out.println(" 0   1   2   3  4  ⠀5   6   7   8  9");
		for(int linha= 0; linha < campoVisual.length; linha++) {
			for(int coluna = 0; coluna < campoVisual.length; coluna++) {
				System.out.print(Cores.TEXT_BLUE_BRIGHT+"["+ campoVisual[linha][coluna] +"]"+Cores.TEXT_RESET);
			}
			System.out.print(" "+linha);
			System.out.println();
		}
		if(pontuacao == 0) {
			System.out.println("\n\nFIM DE JOGO \nvocê não afundou nenhum navio!!");
		}else if(pontuacao == 1) {
			System.out.println("\n\nFIM DE JOGO \nPARABÉNS!!\nvocê afundou "+pontuacao+" navio!!");
		}else if(pontuacao > 1){
			System.out.println("\n\nFIM DE JOGO \nPARABÉNS!!\nvocê afundou "+pontuacao+" navios!!");
		}
		leia.close();
	}	

}
