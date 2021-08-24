package br.com.flank.estacionamento.modelo;

public class Moto extends Veiculo {
	public Moto(String modelo,String cor,String placa) {
		super(modelo,cor,placa);
	}
	
	@Override
	public String toString() {
		return "\nMoto - Valor Do Estacionamento = " + calculoDoEstacionamento()+ super.toString();
	}

	@Override
	public double calculoDoEstacionamento() {
		return 2 + (super.getTempoNoEstacionamento()*0.3);
	}

	
}
