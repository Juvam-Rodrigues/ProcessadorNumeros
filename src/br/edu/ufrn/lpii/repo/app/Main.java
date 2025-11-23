package br.edu.ufrn.lpii.repo.app;

import java.util.Scanner;

import br.edu.ufrn.lpii.repo.arvore_bst_numeros.ArvoreBST;
import br.edu.ufrn.lpii.repo.exceptions.ArquivoNaoEncontradoException;
import br.edu.ufrn.lpii.repo.exceptions.ErroNaReflexaoException;
import br.edu.ufrn.lpii.repo.manipulador_arquivo.ListaArquivos;
import br.edu.ufrn.lpii.repo.manipulador_arquivo.ManipuladorArquivo;

public class Main {
	public static void main(String args[]) {
		ListaArquivos.armazenarCaminhos();
		ArvoreBST<Integer> arvore = new ArvoreBST<>();

		System.out.println("Digite o nome do arquivo no database:");
		Scanner scan = new Scanner(System.in);
		String nome = scan.nextLine();

		try {
			ManipuladorArquivo.lerArquivo(nome, arvore);
			System.out.println("\nImpressão da árvore em ordem:");
			arvore.imprimirArvoreEmOrdem(arvore.getNoRaiz());
			arvore.dobrarValores();
			System.out.println("\nImpressão da árvore em ordem:");
			arvore.imprimirArvoreEmOrdem(arvore.getNoRaiz());
			System.out.println("\n");
			System.out.println("O maior número presente na árvore é: " + arvore.max());
		} catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		
		} catch(ErroNaReflexaoException e) {
			System.out.println(e.getMessage());
		}
		finally {
			scan.close();
		}
	}
}
