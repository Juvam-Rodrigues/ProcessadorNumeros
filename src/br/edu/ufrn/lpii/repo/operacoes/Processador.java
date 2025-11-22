package br.edu.ufrn.lpii.repo.operacoes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.edu.ufrn.lpii.repo.anotacoes.Acao;
import br.edu.ufrn.lpii.repo.arvore_bst_numeros.ArvoreBST;
import br.edu.ufrn.lpii.repo.arvore_bst_numeros.No;
import br.edu.ufrn.lpii.repo.exceptions.ErroNaReflexaoException;

public class Processador {

    public static void imprimirComReflectionAnotation(No no) throws ErroNaReflexaoException {
        if (no == null) return;

        try {
            Class<?> clazz = Class.forName("br.edu.ufrn.lpii.repo.operacoes.Operacoes");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            for (Method metodo : clazz.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Acao.class)) {

                    Class<?>[] params = metodo.getParameterTypes();

                    // Procurando método com assinatura: void imprimir(int)
                    if (params.length == 1 && params[0] == int.class && metodo.getReturnType() == void.class) {
                        metodo.invoke(obj, no.getNumero());
                        return; // Encontrou e executou
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new ErroNaReflexaoException("Erro ao usar reflexão");
        }
    }

    public static void dobrarComReflectionAnotation(ArvoreBST arvore) throws ErroNaReflexaoException {
        try {
            Class<?> clazz = Class.forName("br.edu.ufrn.lpii.repo.operacoes.Operacoes");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            for (Method metodo : clazz.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Acao.class)) {

                    Class<?>[] params = metodo.getParameterTypes();

                    // Procurando método com assinatura: int dobrar(int)
                    if (params.length == 1 && params[0] == int.class && metodo.getReturnType() == int.class) {
                        arvore.dobrarRecursivo(arvore.getNoRaiz(), obj, metodo);
                        return;
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
