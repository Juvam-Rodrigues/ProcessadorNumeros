package br.edu.ufrn.lpii.repo.operacoes;

import br.edu.ufrn.lpii.repo.anotacoes.Acao;
import br.edu.ufrn.lpii.repo.anotacoes.Processar;

@Processar

public class Operacoes {

	@Acao

	public int dobrar(int x) {
		return x * 2;
	}

	@Acao

	public void imprimir(int x) {
		System.out.print(x + " ");
	}

}
