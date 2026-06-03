package entities;

import services.Emprestavel;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Representa um livro no sistema de biblioteca.
 * Implementa Emprestavel para permitir empréstimo e devolução.
 * Identificado de forma única pelo título e ISBN.
 */
public class Livro implements Emprestavel {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean emprestado;

    @Override
    public void emprestar() {
        emprestado = true;
    }

    @Override
    public void devolver() {
        emprestado = false;
    }

    /**
     * Construtor do Livro
     */
    public Livro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    /**
     * Dois livros são iguais se têm o mesmo título E ISBN.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(isbn, livro.isbn);
    }

    /**
     * Hash baseado em título e ISBN para uso em HashSet e HashMap.
     */
    @Override
    public int hashCode() {
        int result = Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(isbn);
        return result;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " | ISBN: " + isbn;
    }
}
