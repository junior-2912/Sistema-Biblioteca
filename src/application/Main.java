package application;

import entities.Biblioteca;
import entities.Livro;
import entities.Usuario;

import java.util.Scanner;

/**
 * Classe principal do Sistema de Biblioteca.
 * Gerencia o menu interativo e coordena as operações da biblioteca.
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int indice;

        while (true) {
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Listar livros");
            System.out.println("6 - Listar usuarios");
            System.out.println("7 - Listar emprestimos");
            System.out.println("8 - Sair");
            System.out.print("Digite um numero: ");
            indice = entrada.nextInt();

            if (indice == 8) break;

            switch (indice) {
                // Cadastro de novo livro no catálogo
                case 1 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE LIVROS");
                    System.out.println("-------------------");

                    entrada.nextLine();
                    System.out.print("Digite o titulo do livro: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = entrada.nextLine();

                    System.out.print("Digite o ISBN do livro: ");
                    String isbn = entrada.nextLine();

                    Livro livro = new Livro(titulo, isbn, autor);
                    biblioteca.cadastrarLivro(livro);
                }

                // Cadastro de novo usuário no sistema
                case 2 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE USUARIOS");
                    System.out.println("-------------------");

                    entrada.nextLine();
                    System.out.print("Digite o nome:");
                    String nome = entrada.nextLine();

                    System.out.print("Digite o ID:");
                    Integer id = entrada.nextInt();

                    Usuario usuario = new Usuario(nome, id);
                    biblioteca.cadastrarUsuario(usuario);
                }

                // Registra empréstimo de livro após validar usuário e livro
                case 3 -> {
                    entrada.nextLine();
                    System.out.print("Digite o ID de quem fara o emprestimo do livro: ");
                    Integer id = entrada.nextInt();

                    Usuario usuario = biblioteca.buscarUsuario(id);
                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                        continue;
                    }

                    entrada.nextLine();
                    System.out.print("Digite o ISBN do livro que deseja emprestar: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);
                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                        continue;
                    }

                    System.out.println(biblioteca.emprestarLivro(livro, usuario));
                }

                // Processa devolução de livro após validar usuário e livro
                case 4 -> {
                    entrada.nextLine();
                    System.out.print("Digite o ID de quem fara a devolucao do livro: ");
                    Integer id = entrada.nextInt();

                    Usuario usuario = biblioteca.buscarUsuario(id);
                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                        continue;
                    }

                    entrada.nextLine();
                    System.out.print("Digite o ISBN do livro que deseja devolver: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);
                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                        continue;
                    }

                    System.out.println(biblioteca.devolverLivro(usuario, livro));
                }

                // Exibe todos os livros cadastrados no catálogo
                case 5 -> {
                    System.out.println("-------------------");
                    System.out.println("LISTAGEM DE LIVROS");
                    System.out.println("-------------------");
                    biblioteca.listarLivros();
                }

                // Exibe todos os usuários cadastrados no sistema
                case 6 -> {
                    System.out.println("-------------------");
                    System.out.println("LISTAGEM DE USUARIOS");
                    System.out.println("-------------------");
                    biblioteca.listarUsuarios();
                }

                // Exibe todos os empréstimos realizados
                case 7 -> {
                    System.out.println("-----------------------");
                    System.out.println("LISTAGEM DE EMPRESTIMOS");
                    System.out.println("-----------------------");
                    biblioteca.listarEmprestimos();
                }

                default -> System.out.println("Digite um numero valido!!");
            }
        }

        entrada.close();
    }
}
