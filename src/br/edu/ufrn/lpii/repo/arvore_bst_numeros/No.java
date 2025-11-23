package br.edu.ufrn.lpii.repo.arvore_bst_numeros;

public class No<T extends Comparable<T>> {

	private T numero;           // Valor do nó (antes era int)
	private No<T> noEsquerdo;  // Ponteiro para esquerda
	private No<T> noDireito;   // Ponteiro para direita

	public No(T numero) {
		this.numero = numero;
	}

	public T getNumero() {
		return numero;
	}

	public void setNumero(T numero) {
		this.numero = numero;
	}

	public No<T> getNoEsquerdo() {
		return noEsquerdo;
	}

	public void setNoEsquerdo(No<T> noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public No<T> getNoDireito() {
		return noDireito;
	}

	public void setNoDireito(No<T> noDireito) {
		this.noDireito = noDireito;
	}

	// getValor foi renomeado para compatibilizar com seu código antigo (opcional)
	public T getValor() {
		return numero;
	}

	public void setValor(T valor) {
		this.numero = valor;
	}
}
