package br.com.flank.estacionamento.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.flank.estacionamento.modelo.Veiculo;

public class Vagas {
	
	private Collection <Veiculo> veiculo = new ArrayList<>();
	private Map <String,Veiculo> veiculoLinkados = new HashMap<>();
	
	public Collection <Veiculo> getVeiculo() {
		return Collections.unmodifiableCollection(veiculo);
	}

	public void adiciona(Veiculo veiculo) {
		this.veiculo.add(veiculo);
		this.veiculoLinkados.put(veiculo.getPlaca(), veiculo);
	}
	
	public void atualizaPlaca(String oldPlaca, String newPlaca,Veiculo veiculo) {
		Veiculo atual = veiculoLinkados.remove(oldPlaca);
		this.veiculoLinkados.put(newPlaca, atual);
	}

	public Veiculo buscarCarro(String key) {
		return this.veiculoLinkados.get(key);
	}

	public void remover(String key,Veiculo veiculoBuscado3) {
		veiculoLinkados.remove(key,veiculoBuscado3);
	}
}
