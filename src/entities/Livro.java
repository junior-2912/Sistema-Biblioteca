package entities;

import services.Emprestavel;

import java.util.Objects;

/**
 * Classe que representa um Livro no sistema de biblioteca.
 *
 * A classe implementa a interface Emprestavel, indicando que um livro pode ser
 * emprestado e devolvido. Os livros são identificados de forma única pelo título
 * e ISBN para evitar duplicatas no catálogo.
 *
 * @author Sistema de Biblioteca
 * @version 1.0
 */
public class Livro implements Emprestavel {
    // Propriedades do livro
    private String titulo;   // Título do livro
    private String isbn;     // ISBN (International Standard Book Number) - identificador único
    private String autor;    // Nome do autor do livro

    /**
     * Implementação do método emprestar() da interface Emprestavel.
     * Este método será executado quando um livro for emprestado.
     *
     * ⚠️ AINDA NÃO IMPLEMENTADO - Aguardando lógica de controle de disponibilidade
     */
    @Override
    public void emprestar() {
        // TODO: Implementar lógica de empréstimo
        // - Verificar se o livro está disponível
        // - Atualizar status de disponibilidade
        // - Registrar data/hora do empréstimo
    }

    /**
     * Implementação do método devolver() da interface Emprestavel.
     * Este método será executado quando um livro for devolvido.
     *
     * ⚠️ AINDA NÃO IMPLEMENTADO - Aguardando lógica de controle de disponibilidade
     */
    @Override
    public void devolver() {
        // TODO: Implementar lógica de devolução
        // - Verificar se o livro está emprestado
        // - Atualizar status de disponibilidade
        // - Registrar data/hora da devolução
    }

    /**
     * Construtor do Livro
     *
     * @param titulo O título do livro
     * @param isbn O identificador único do livro (ISBN)
     * @param autor O nome do autor do livro
     */
    public Livro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    /**
     * Retorna o título do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna o ISBN do livro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Retorna o autor do livro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Compara dois livros para verificar se são iguais.
     * Dois livros são considerados iguais se tiverem o mesmo título E ISBN.
     *
     * @param o Objeto a ser comparado
     * @return true se os livros são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;
        // Compara título e ISBN para identificar livros únicos
        return Objects.equals(titulo, livro.titulo) && Objects.equals(isbn, livro.isbn);
    }

    /**
     * Gera um código hash para o livro baseado no título e ISBN.
     * Essencial para usar a classe em HashSet e HashMap.
     *
     * @return hash code baseado em título e ISBN
     */
    @Override
    public int hashCode() {
        // Combina o hash do título com o hash do ISBN
        int result = Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(isbn);
        return result;
    }
}
