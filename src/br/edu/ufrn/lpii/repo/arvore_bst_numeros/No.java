package br.edu.ufrn.lpii.repo.arvore_bst_numeros;

import java.util.Objects;

public class No {

    private int numero;
    private No noEsquerdo; // Nó que aponta para o valor menor
    private No noDireito;  // Nó que aponta para o valor maior

    public No(int valor) {
        this.numero = valor;
        this.noEsquerdo = null;
        this.noDireito = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        No other = (No) obj;
        return numero == other.numero;
    }
}
