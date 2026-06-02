package entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe responsável por gerenciar o catálogo de livros, usuários e empréstimos.
 * Funciona como Facade centralizado para as operações da biblioteca.
 */
public class Biblioteca {
    // HashSet armazena livros únicos no catálogo (evita duplicatas)
    Set<Livro> livros = new HashSet<>();

    // HashSet armazena usuários únicos do sistema (evita duplicatas)
    Set<Usuario> usuarios = new HashSet<>();

    // HashMap mantém o controle de empréstimos: Usuário -> Conjunto de Livros Emprestados
    Map<Usuario, Set<Livro>> emprestimos = new HashMap<>();

    /**
     * Cadastra um livro no catálogo.
     */
    public void cadastrarLivro(Livro livro) {
        // Tenta adicionar o livro. Se for bem-sucedido, Set retorna true (livro não existia)
        if (livros.add(livro)) {
            System.out.println("Livro adicionado ao catalogo!");
        } else {
            // Se retornar false, o livro já estava cadastrado (duplicata)
            System.out.println("Livro ja cadastrado!");
        }
    }

    /**
     * Cadastra um usuário no sistema.
     */
    public void cadastrarUsuario(Usuario usuario) {
        // Tenta adicionar o usuário. Set retorna true se for a primeira vez
        if (usuarios.add(usuario)) {
            System.out.println("Usuario cadastrado com sucesso!");
        } else {
            // Se retornar false, o usuário já existe (ID duplicado)
            System.out.println("Usuario ja existe!");
        }
    }

    /**
     * Registra o empréstimo de um livro a um usuário.
     */
    public String emprestarLivro(Livro livro, Usuario usuario) {
        if (!emprestimos.containsKey(usuario)) {
            emprestimos.put(usuario, new HashSet<>());
        }
        emprestimos.get(usuario).add(livro);
        livro.emprestar();
        return usuario.getNome()  + " fez um emprestimo do livro: " + livro.getTitulo();
    }

    /**
     * Busca um usuário pelo ID.
     */
    public Usuario buscarUsuario(Integer id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca um livro pelo ISBN.
     */
    public Livro buscarLivro(String isbn) {
        for (Livro l : livros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Processa a devolução de um livro emprestado.
     */
    public String devolverLivro (Usuario usuario, Livro livro) {
        if (!emprestimos.get(usuario).contains(livro)) {
            return "O livro " + livro.getTitulo() + " nao foi emprestado a " +  usuario.getNome();
        } else {
            emprestimos.get(usuario).remove(livro);
            livro.devolver();
            return "O livro foi devolvido com sucesso!";
        }
    }

    public void listarLivros() {

    }
}
