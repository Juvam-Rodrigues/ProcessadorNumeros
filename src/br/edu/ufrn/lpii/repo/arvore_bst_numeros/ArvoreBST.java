package br.edu.ufrn.lpii.repo.arvore_bst_numeros;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import br.edu.ufrn.lpii.repo.exceptions.ErroNaReflexaoException;
import br.edu.ufrn.lpii.repo.operacoes.Processador;

public class ArvoreBST<T extends Comparable<T>> {
// Será uma árvore binária de busca
	private No<T> noRaiz;

	public ArvoreBST() {
		noRaiz = null;
	}

	public No<T> getNoRaiz() {
		return noRaiz;
	}

	public void inserir(T valor) {
		No<T> novoNo = new No<>(valor);
		if (noRaiz == null) { // Caso a árvore esteja vazia
			noRaiz = novoNo;
			System.out.println(valor + " virou raiz da árvore.");
		} else if (buscar(valor) != null) {
			System.out.println("Valor já está na árvore.");
		} else {
			No<T> noAtual = noRaiz;
			No<T> noPai;
			while (true) {
				noPai = noAtual;
				// compareTo no lugar de operadores (pois agora T é genérico)
				if (valor.compareTo(noAtual.getValor()) < 0) { // ir para esquerda
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

	public No<T> buscar(T chave) {
		if (noRaiz == null) {
			return null; // se árvore vazia
		}
		No<T> noAtual = noRaiz; // começa a procurar desde raiz
		while (noAtual != null) {
			int cmp = chave.compareTo(noAtual.getValor());

			if (cmp == 0) return noAtual; // Achou

			if (cmp < 0) {
				noAtual = noAtual.getNoEsquerdo();
			} else {
				noAtual = noAtual.getNoDireito();
			}
		}
		return null; // Chegou numa folha e não achou nada...
	}

	public void dobrarValores() throws ErroNaReflexaoException {
		Processador.dobrarComReflectionAnotation(this); //Somente chama para fazer o reflection
	}

	public void dobrarRecursivo(No<T> no, Object obj, Method m) throws ErroNaReflexaoException {
		//Ao receber o metodo de processador vai dobrar recursivamente 
		if (no == null) { 
			return; // Chegou na folha
		}
		try {
			dobrarRecursivo(no.getNoEsquerdo(), obj, m); //Dobra em ordem

			@SuppressWarnings("unchecked") 
			//Usamos esse warning para dizer que sabemos que o tipo de objeto retornado pode ser convertido para T
			T valorDobrado = (T) m.invoke(obj, no.getValor());
			no.setValor(valorDobrado);

			dobrarRecursivo(no.getNoDireito(), obj, m);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ErroNaReflexaoException("Erro ao usar reflexão");
		}
	}
	
	public void imprimirArvoreEmOrdem(No<T> no) throws ErroNaReflexaoException { //Método que imprime árvore em ordem
		if (no != null) {
			imprimirArvoreEmOrdem(no.getNoEsquerdo());
			Processador.imprimirComReflectionAnotation(no); //Imprime via anotação
			imprimirArvoreEmOrdem(no.getNoDireito());
		}
	}

	// Retorna o maior elemento da ABB
	public T max() {
		if (noRaiz == null) return null;

		No<T> atual = noRaiz;

		// maior número está na direita
		while (atual.getNoDireito() != null) {
			atual = atual.getNoDireito();
		}

		return atual.getValor();
	}
}
