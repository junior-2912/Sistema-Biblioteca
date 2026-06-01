package services;

/**
 * Interface que define o contrato para objetos que podem ser emprestados em uma biblioteca.
 *
 * Esta interface estabelece que qualquer objeto emprestável deve implementar
 * a lógica de empréstimo e devolução. No contexto deste projeto, a classe Livro
 * implementa esta interface.
 *
 * Padrão: Strategy Pattern
 * Benefício: Permite que qualquer tipo de item (Livro, DVD, etc.) possa ser
 * emprestado/devolvido com a mesma interface.
 *
 * @author Sistema de Biblioteca
 * @version 1.0
 */
public interface Emprestavel {
    /**
     * Executa a lógica de empréstimo de um item.
     * Deve atualizar o status do item e registrar informações do empréstimo.
     */
    void emprestar();

    /**
     * Executa a lógica de devolução de um item.
     * Deve restaurar o status do item e registrar informações da devolução.
     */
    void devolver();
}
