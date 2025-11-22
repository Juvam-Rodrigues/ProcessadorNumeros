package br.edu.ufrn.lpii.repo.manipulador_arquivo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListaArquivos {
	private static List<String> arquivos; //Aqui conterá todos os caminhos de arquivos presentes na pasta database
	
	
    public static void armazenarCaminhos() { 
        String caminhoPasta = "src/br/edu/ufrn/lpii/repo/database"; 
        File pasta = new File(caminhoPasta);

        arquivos = new ArrayList<>();

        if (pasta.exists() && pasta.isDirectory()) {
            File[] listaArquivos = pasta.listFiles();

            if (listaArquivos != null) { //Se existe arquivos na pasta
                for (File f : listaArquivos) {
                    if (f.isFile()) { 
                        arquivos.add(f.getAbsolutePath()); 
                    }
                }
            }
        }

    }
    public static List<String> getCaminhos(){
    	return arquivos;
    }
}