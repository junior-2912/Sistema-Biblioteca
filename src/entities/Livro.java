package entities;

import services.Emprestavel;

import java.util.Objects;

public class Livro implements Emprestavel {
    private String titulo;
    private String isbn;
    private String autor;

    @Override
    public void emprestar() {

    }

    @Override
    public void devolver() {

    }

    public Livro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(isbn);
        return result;
    }
}
