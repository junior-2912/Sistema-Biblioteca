package utility;

import java.util.List;
import java.util.Set;

/**
 * Classe genérica para impressão e exibição de relatórios.
 *
 * Esta classe utiliza Generics (<T>) para permitir a impressão de qualquer tipo
 * de lista, sem necessidade de conversão de tipos. É útil para exibir relatórios
 * de livros, usuários, empréstimos, etc.
 *
 * Padrão: Generic Class + Template Method
 * Benefício: Reutilizável para qualquer tipo de objeto, mantendo type safety.
 *
 * @param <T> Tipo genérico de objeto que será exibido no relatório
 * @author Sistema de Biblioteca
 * @version 1.0
 */
public class Relatorio<T> {
    /**
     * Imprime todos os elementos de um conjunto na tela.
     */
    public void imprimir(Set<T> lista) {
        for (T t : lista) {
            System.out.println(t);
        }
    }
}
