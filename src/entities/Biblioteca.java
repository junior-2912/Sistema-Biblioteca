package entities;

import utility.Relatorio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe que gerencia o catálogo de livros, usuários e empréstimos.
 * Atua como Facade centralizado para todas as operações da biblioteca.
 */
public class Biblioteca {
    Set<Livro> livros = new HashSet<>();
    Set<Usuario> usuarios = new HashSet<>();
    Map<Usuario, Set<Livro>> emprestimos = new HashMap<>();

    /**
     * Cadastra um livro no catálogo. Verifica se o livro já existe.
     */
    public void cadastrarLivro(Livro livro) {
        if (livros.add(livro)) {
            System.out.println("Livro adicionado ao catalogo!");
        } else {
            System.out.println("Livro ja cadastrado!");
        }
    }

    /**
     * Cadastra um usuário no sistema. Verifica se o usuário já existe.
     */
    public void cadastrarUsuario(Usuario usuario) {
        if (usuarios.add(usuario)) {
            System.out.println("Usuario cadastrado com sucesso!");
        } else {
            System.out.println("Usuario ja existe!");
        }
    }

    /**
     * Registra o empréstimo de um livro a um usuário.
     * Valida se o livro já foi emprestado antes de registrar.
     * Retorna mensagem descritiva do resultado.
     */
    public String emprestarLivro(Livro livro, Usuario usuario) {
        if (usuario == null) {
            return "O usuario nao existe!";
        }
        if (livro == null) {
            return "O livro nao existe!";
        }

        if (livro.isEmprestado()) {
            return "O livro ja foi emprestado";
        }
        // Cria um novo Set para o usuário se não existir
        emprestimos.putIfAbsent(usuario, new HashSet<>());

        emprestimos.get(usuario).add(livro);

        livro.emprestar();

        return usuario.getNome() + " fez um emprestimo do livro: " + livro.getTitulo();
    }

    /**
     * Busca um usuário pelo ID no sistema.
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
     * Busca um livro pelo ISBN no catálogo.
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
     * Realiza validações de usuário e livro, verifica se o livro foi realmente emprestado.
     * Retorna mensagem descritiva do resultado.
     */
    public String devolverLivro(Usuario usuario, Livro livro) {
        if (usuario == null) {
            return "O usuario nao existe!";
        }
        if (livro == null) {
            return "O livro nao existe!";
        }

        Set<Livro> livrosEmprestados = emprestimos.get(usuario);
        if (livrosEmprestados == null) {
            return "O usuario nunca fez emprestimos!";
        }
        if (!livrosEmprestados.contains(livro)) {
            return "O livro " + livro.getTitulo() + " nao foi emprestado a " + usuario.getNome();
        }

        livrosEmprestados.remove(livro);
        livro.devolver();
        return "O livro foi devolvido com sucesso!";
    }

    /**
     * Exibe todos os livros cadastrados no catálogo.
     */
    public void listarLivros() {
        Relatorio<Livro> relatorioLivros = new Relatorio<>();
        relatorioLivros.imprimir(livros);
    }

    /**
     * Exibe todos os usuários cadastrados no sistema.
     */
    public void listarUsuarios() {
        Relatorio<Usuario> relatorioUsuarios = new Relatorio<>();
        relatorioUsuarios.imprimir(usuarios);
    }

    /**
     * Exibe todos os empréstimos realizados, agrupados por usuário.
     */
    public void listarEmprestimos() {
        for (Map.Entry<Usuario, Set<Livro>> map : emprestimos.entrySet()) {
            Usuario usuario = map.getKey();
            Set<Livro> livros = map.getValue();
            System.out.println(usuario + " { " + livros + " }");
        }
    }
}
