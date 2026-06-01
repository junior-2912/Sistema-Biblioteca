package utility;

import java.util.List;

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
     * Imprime uma lista de objetos do tipo T na tela.
     *
     * ⚠️ AINDA NÃO IMPLEMENTADO - Aguardando formatação de saída
     *
     * @param lista Lista de objetos a serem impressos
     *
     * TODO: Implementar a lógica de impressão
     * - Iterar pela lista
     * - Formatar cada item para exibição
     * - Exibir número total de itens
     * - Contabilizar informações relevantes
     */
    public void imprimir(List<T> lista) {
        // TODO: Implementar impressão da lista com formatação apropriada
    }
}
