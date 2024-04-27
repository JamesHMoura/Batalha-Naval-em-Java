package batalhanaval;

import java.util.Scanner;



public class BatalhaNaval {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		do {
			System.out.println(""" 
					________________________
					1 - Iniciar nova partida
					2 - sair
					________________________
					
					escolha uma opção:
					""");
			
			opcao = leia.nextInt();
			
			switch(opcao) {
			case 1:
				Metodos.jogo();
				break;
			case 2:
				System.out.println("ATE A PROXIMA BATALHA!!");
				break;
			default:
				System.out.println("Digite uma opção válida");
				break;
			}
			leia.nextLine();
		}while(opcao != 2);
		leia.close();
	}
}
