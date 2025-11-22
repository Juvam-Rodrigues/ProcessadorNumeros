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
		ArvoreBST arvore = new ArvoreBST();

		System.out.println("Digite o nome do arquivo no database:");
		Scanner scan = new Scanner(System.in);
		String nome = scan.nextLine();

		try {
			ManipuladorArquivo.lerArquivo(nome, arvore);
			arvore.imprimirArvoreEmOrdem(arvore.getNoRaiz());
			arvore.dobrarValores();
			System.out.println();
			arvore.imprimirArvoreEmOrdem(arvore.getNoRaiz());
		} catch(ArquivoNaoEncontradoException e) {
			System.out.println(e);
		
		} catch(ErroNaReflexaoException e) {
			System.out.println(e);
		}
		finally {
			scan.close();
		}
	}
}
