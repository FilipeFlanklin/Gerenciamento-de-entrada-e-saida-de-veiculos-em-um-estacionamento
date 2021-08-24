package br.com.flank.estacionamento.auxiliar;

import java.util.Scanner;

public abstract class Menu {
	public static int menuOpcao() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1 - Entrada de veiculo");
		System.out.println("2 - Consultar estado do veiculo");
		System.out.println("3 - Atualizar estado do veiculo");
		System.out.println("4 - Saida de veiculo");
		System.out.println("5 - Listar todos veiculos");
		System.out.println("0 - Sair");
		System.out.print("Digite uma opção: ");
		return scan.nextInt();
		
	}
}
