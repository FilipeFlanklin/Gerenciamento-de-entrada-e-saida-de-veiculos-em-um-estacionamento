package br.com.flank.estacionamento.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Veiculo implements ValorEstacionamento{
	private String placa;
	private String modelo;
	private String cor;
	private LocalDateTime horarioEntrada = LocalDateTime.now();
	
	public Veiculo(String modelo,String cor,String placa) {
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}

	public String getPlaca() {
		return this.placa;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getCor() {
		return this.cor;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public LocalDateTime getHorarioEntrada() {
		return this.horarioEntrada;
	}
	
	public double getTempoNoEstacionamento() {
		Duration date = (Duration.between(this.horarioEntrada, LocalDateTime.now()));
		return date.toMinutesPart();
	}
	
	
	@Override
	public String toString() {
		return "\nmodelo : " + this.modelo 
			+ "\nCor: " + this.cor 
			+ "\nPlaca: " + this.placa  
			+ "\nHorario de entrada: " + this.horarioEntrada.format(DateTimeFormatter.ofPattern("HH:mm")) + "\r\n";
	}

	
}
