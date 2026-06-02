package entities;

import services.Emprestavel;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa um Livro no sistema de biblioteca.
 * <p>
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
    private boolean emprestado;


    /**
     * Marca o livro como emprestado.
     */
    @Override
    public void emprestar() {
        emprestado = true;
    }

    /**
     * Marca o livro como devolvido.
     */
    @Override
    public void devolver() {
        emprestado = false;
    }

    /**
     * Construtor do Livro
     *
     * @param titulo O título do livro
     * @param isbn   O identificador único do livro (ISBN)
     * @param autor  O nome do autor do livro
     */
    public Livro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public boolean isEmprestado() {
        return emprestado;
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
        // Verifica se o objeto é nulo ou de uma classe diferente
        if (o == null || getClass() != o.getClass()) return false;

        // Converte o objeto para Livro e compara título e ISBN
        Livro livro = (Livro) o;
        // Dois livros são iguais se têm MESMO título E MESMO ISBN
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
        // Calcula o hash do título e do ISBN usando Objects.hashCode()
        // Combina os dois hashes usando a fórmula 31 * hash + novo_hash para evitar colisões
        int result = Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(isbn);
        return result;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " | ISBN: " + isbn;
    }
}
