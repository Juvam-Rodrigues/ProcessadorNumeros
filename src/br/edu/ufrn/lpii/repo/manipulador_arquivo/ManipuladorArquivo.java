package br.edu.ufrn.lpii.repo.manipulador_arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import br.edu.ufrn.lpii.repo.arvore_bst_numeros.ArvoreBST;
import br.edu.ufrn.lpii.repo.exceptions.ArquivoNaoEncontradoException;
import br.edu.ufrn.lpii.repo.exceptions.NumeroNegativoOuNuloException;

public class ManipuladorArquivo {

	public static void lerArquivo(String nome, ArvoreBST arvore) 
			throws ArquivoNaoEncontradoException {

		List<String> caminhos = ListaArquivos.getCaminhos();

		String caminhoEncontrado = "";
		boolean encontrado = false;
		for (String caminho : caminhos) {
			File f = new File(caminho);
			if (f.getName().equals(nome)) { // Verifica se o arquivo está entre os que estão no database a partir do nome
				encontrado = true;
				caminhoEncontrado = caminho;
				break;
			}
		}

		if (encontrado == false) {
			throw new ArquivoNaoEncontradoException("Erro: arquivo não encontrado...");
		} else {
			preencherEstrutura(caminhoEncontrado, arvore);
		}
	}

	public static void preencherEstrutura(String caminho, ArvoreBST arvore){
		File arquivo = new File(caminho);
		
		try (Scanner scanner = new Scanner(arquivo)) {
			int atual;
			while (scanner.hasNextLine()) { // Enquanto houver linhas
				try {
					atual = Integer.parseInt(scanner.nextLine()); //Tenta passar o caractere para inteiro
					if (atual <= 0) {
						throw new NumeroNegativoOuNuloException("Erro: número não permitido pela regra de negócio.");
					}
					
					arvore.inserir(atual); //Deu tudo certo! Pode inserir na árvore.
					
				} catch (NumberFormatException e) {
					System.out.println("Erro: número inválido...");
				}
				catch(NumeroNegativoOuNuloException e){
					System.out.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e1) {
			//Erro já tratado mais acima
		}
		
	}
}
