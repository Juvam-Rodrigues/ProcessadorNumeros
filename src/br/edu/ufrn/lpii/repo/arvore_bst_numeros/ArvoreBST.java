package br.edu.ufrn.lpii.repo.arvore_bst_numeros;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import br.edu.ufrn.lpii.repo.exceptions.ErroNaReflexaoException;
import br.edu.ufrn.lpii.repo.operacoes.Processador;

public class ArvoreBST {
// Será uma árvore binária de busca
	private No noRaiz;

	public ArvoreBST() {
		noRaiz = null;
	}

	public No getNoRaiz() {
		return noRaiz;
	}

	public void inserir(int valor) {
		No novoNo = new No(valor);
		if (noRaiz == null) { // Caso a árvore esteja vazia
			noRaiz = novoNo;
			System.out.println(valor + " virou raiz da árvore.");
		} else if (buscar(valor) != null) {
			System.out.println("Valor já está na árvore.");
		} else {
			No noAtual = noRaiz;
			No noPai;
			while (true) {
				noPai = noAtual;
				if (valor <= noAtual.getNumero()) { // ir para esquerda
					noAtual = noAtual.getNoEsquerdo();
					if (noAtual == null) {
						noPai.setNoEsquerdo(novoNo);
						System.out.println(valor + " foi inserido.");
						return;
					}
				} else { // ir para direita
					noAtual = noAtual.getNoDireito();
					if (noAtual == null) {
						noPai.setNoDireito(novoNo);
						System.out.println(valor + " foi inserido.");
						return;
					}
				}
			}
		}
	}

	public No buscar(int chave) {
		if (noRaiz == null) {
			return null; // se árvore vazia
		}
		No noAtual = noRaiz; // começa a procurar desde raiz
		while (noAtual.getNumero() != chave) {
			if (chave < noAtual.getNumero()) {
				noAtual = noAtual.getNoEsquerdo();
			} else {
				noAtual = noAtual.getNoDireito();
			}
			if (noAtual == null) {
				return null; // Chegou numa folha e não achou nada...
			}
		}
		return noAtual;
	}

	public void dobrarValores() throws ErroNaReflexaoException {
		Processador.dobrarComReflectionAnotation(this); //Somente chama para fazer o reflection
	}

	public void dobrarRecursivo(No no, Object obj, Method m) throws ErroNaReflexaoException {
		//Ao receber o metodo de processador vai dobrar recursivamente 
		if (no == null) { 
			return; // Chegou na folha
		}
		try {
			dobrarRecursivo(no.getNoEsquerdo(), obj, m); //Dobra em ordem
			int valorDobrado = (int) m.invoke(obj, no.getNumero());
			no.setNumero(valorDobrado);
			dobrarRecursivo(no.getNoDireito(), obj, m);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ErroNaReflexaoException("Erro ao usar reflexão");
		}
	}
	
	public void imprimirArvoreEmOrdem(No no) throws ErroNaReflexaoException { //Método que imprime árvore em ordem
		if (no != null) {
			imprimirArvoreEmOrdem(no.getNoEsquerdo());
			Processador.imprimirComReflectionAnotation(no);
			imprimirArvoreEmOrdem(no.getNoDireito());

		}
	}
}
