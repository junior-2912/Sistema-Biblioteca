package utility;

import java.util.List;
import java.util.Set;

/**
 * Classe genérica para impressão de relatórios.
 * Permite exibição formatada de qualquer tipo de coleção sem necessidade de casting.
 * Utiliza Generics para type safety e reutilizabilidade.
 */
public class Relatorio<T> {
    /**
     * Imprime todos os elementos de um conjunto na tela.
     */
    public void imprimir(Set<T> lista) {
        System.out.println("==================================");
        for (T t : lista) {
            System.out.println(t);
            System.out.println("==================================");
        }
        System.out.println("==================================");
    }
}
