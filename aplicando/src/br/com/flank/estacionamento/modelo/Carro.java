package br.com.flank.estacionamento.modelo;

public class Carro extends Veiculo{
	public Carro(String modelo,String cor,String placa) {
		super(modelo,cor,placa);
	}
	
	@Override
	public String toString() {
		return "\nCarro - Valor até o momento = $"+ calculoDoEstacionamento() + super.toString();
	}

	@Override
	public double calculoDoEstacionamento() {
		return 2.5 + (super.getTempoNoEstacionamento()*0.4);
	}

	
}
