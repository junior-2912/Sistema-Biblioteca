package services;

import entities.Livro;
import entities.Usuario;

import java.util.Map;
import java.util.Set;

/**
 * Interface que define o contrato para objetos emprestáveis.
 * Permite que diferentes tipos de itens (Livro, DVD, etc.) implementem
 * lógica de empréstimo e devolução de forma consistente.
 */
public interface Emprestavel {
    /**
     * Marca o item como emprestado.
     */
    void emprestar();

    /**
     * Marca o item como devolvido.
     */
    void devolver();
}
