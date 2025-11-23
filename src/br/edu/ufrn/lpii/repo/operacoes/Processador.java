package br.edu.ufrn.lpii.repo.operacoes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.edu.ufrn.lpii.repo.anotacoes.Acao;
import br.edu.ufrn.lpii.repo.arvore_bst_numeros.ArvoreBST;
import br.edu.ufrn.lpii.repo.arvore_bst_numeros.No;
import br.edu.ufrn.lpii.repo.exceptions.ErroNaReflexaoException;

public class Processador {

    public static <T extends Comparable<T>> void imprimirComReflectionAnotation(No<T> no) throws ErroNaReflexaoException {
        //extende-se o comparable mesmo que não realiza-se comparações para o java não reclamar
    	if (no == null) {
    		return; //Se o nó é null, não adianta imprimir 
    	}

        try {
            Class<?> clazz = Class.forName("br.edu.ufrn.lpii.repo.operacoes.Operacoes");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            for (Method metodo : clazz.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Acao.class)) {

                    Class<?>[] params = metodo.getParameterTypes();

                    // Procurando método com assinatura: void imprimir(int)
                    if (params.length == 1 && params[0] == int.class && metodo.getReturnType() == void.class) {
                        metodo.invoke(obj, no.getNumero()); //Imprime o número a partir do método com as características acima
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
           throw new ErroNaReflexaoException("Erro ao usar reflexão");
       }

    }

    public static <T extends Comparable<T>> void dobrarComReflectionAnotation(ArvoreBST<T> arvore) throws ErroNaReflexaoException {
        //extende-se o comparable mesmo que não realiza-se comparações para o java não reclamar

    	try {
            Class<?> clazz = Class.forName("br.edu.ufrn.lpii.repo.operacoes.Operacoes");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            for (Method metodo : clazz.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Acao.class)) {

                    Class<?>[] params = metodo.getParameterTypes();

                    // Procurando método com assinatura: int dobrar(int)
                    if (params.length == 1 && params[0] == int.class && metodo.getReturnType() == int.class) {
                        //Manda-se o método que dobra o número para dobrar recursivamente
                    	arvore.dobrarRecursivo(arvore.getNoRaiz(), obj, metodo);
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new ErroNaReflexaoException("Erro ao usar reflexão");
        }
    }
}
