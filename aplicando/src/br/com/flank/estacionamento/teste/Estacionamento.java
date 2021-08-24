package br.com.flank.estacionamento.teste;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.flank.estacionamento.auxiliar.Menu;
import br.com.flank.estacionamento.modelo.Carro;
import br.com.flank.estacionamento.modelo.Moto;
import br.com.flank.estacionamento.modelo.Veiculo;

public class Estacionamento {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		int opcao = 0;
		Vagas vaga = new Vagas();
		Scanner scan = new Scanner(System.in);

		do {
			opcao = Menu.menuOpcao();
			switch (opcao) {
			case 1:
				System.out.println("\n*Entrada de Veiculo*\n");

				System.out.print("Qual o modelo: ");
				String modelo = scan.next();
				System.out.print("Qual a cor: ");
				String cor = scan.next();
				System.out.print("Qual a placa: ");
				String placa = scan.next();

				System.out.print("Digite c para carros ou m para motos: ");
				switch (scan.next().charAt(0)) {
				case 'c':
					Veiculo carro = new Carro(modelo, cor, placa);
					vaga.adiciona(carro);
					break;
				case 'm':
					Veiculo moto = new Moto(modelo, cor, placa);
					vaga.adiciona(moto);
					break;

				default:
					throw new NoSuchElementException("Tipo do Veiculo invalido");
				}
				System.out.println();
				break;
			case 2:
				System.out.println("\n*Consulta de Veiculo*\n");

				System.out.print("Placa do veiculo: ");
				Veiculo veiculoBuscado = vaga.buscarCarro(scan.next());
				if (veiculoBuscado != null)
					System.out.println(veiculoBuscado);
				else
					System.out.println("\n Veiculo não esta no estacionamento! \n");
				break;
			case 3:
				System.out.println("\n*Alterar Veiculo cadastrado*\n");

				System.out.print("Placa do veiculo: ");
				Veiculo veiculoBuscado2 = vaga.buscarCarro(scan.next());
				if (veiculoBuscado2 != null) {
					String oldPlaca = veiculoBuscado2.getPlaca();
					System.out.print("Qual é o novo modelo: ");
					veiculoBuscado2.setModelo(scan.next());
					System.out.print("Qual é a nova cor: ");
					veiculoBuscado2.setCor(scan.next());
					System.out.print("Qual é a nova placa: ");
					veiculoBuscado2.setPlaca(scan.next());
					vaga.atualizaPlaca(oldPlaca, veiculoBuscado2.getPlaca(), veiculoBuscado2);
					System.out.println();
				} else
					System.out.println("\n Veiculo não esta no estacionamento! \n");
				break;
			case 4:
				System.out.println("\n*Consulta de Veiculo*\n");

				System.out.print("Placa do veiculo: ");
				String placaVeiculoRemovido = scan.next();
				Veiculo veiculoBuscado3 = vaga.buscarCarro(placaVeiculoRemovido);
				if (veiculoBuscado3 != null) {
					vaga.remover(placaVeiculoRemovido, veiculoBuscado3);
					System.out.println("\n Veiculo removido do estacionamento");
				} else
					System.out.println("\n Veiculo não esta no estacionamento! \n");
				break;
			case 5:
				System.out.println("\n*Lista de todos Veiculos*\n");
				
				vaga.getVeiculo().forEach(System.out::println);
				System.out.println("\n*Fim da lista!*\n");
				
				break;
			case 0:
				System.out.println("Fim da execução");
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
		} while (opcao != 0);
		scan.close();
	}
}
