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
        // Percorre o conjunto de usuários
        for (Usuario u : usuarios) {
            // Se encontrar um usuário com o ID procurado, retorna imediatamente
            if (u.getId().equals(id)) {
                return u;
            }
        }
        // Se nenhum usuário foi encontrado, retorna null
        return null;
    }

    /**
     * Busca um livro pelo ISBN.
     */
    public Livro buscarLivro(String isbn) {
        // Percorre o catálogo de livros
        for (Livro l : livros) {
            // Se encontrar um livro com o ISBN procurado, retorna imediatamente
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        // Se nenhum livro foi encontrado, retorna null
        return null;
    }

    /**
     * Processa a devolução de um livro emprestado.
     */
    public String devolverLivro (Usuario usuario, Livro livro) {
        // Verifica se o livro está nos empréstimos do usuário
        if (!emprestimos.get(usuario).contains(livro)) {
            // Se o livro não foi emprestado ao usuário, retorna mensagem de erro
            return "O livro " + livro.getTitulo() + " nao foi emprestado a " +  usuario.getNome();
        } else {
            // Remove o livro do conjunto de empréstimos do usuário
            emprestimos.get(usuario).remove(livro);
            // Marca o livro como devolvido
            livro.devolver();
            // Retorna mensagem de sucesso
            return "O livro foi devolvido com sucesso!";
        }
    }

    public void listarLivros() {

    }
}
