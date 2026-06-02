package application;

import entities.Biblioteca;
import entities.Livro;
import entities.Usuario;
import utility.Relatorio;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Classe principal do Sistema de Biblioteca.
 * Responsável pelo menu interativo e orquestração das operações.
 */
public class Main {
    public static void main(String[] args) {
        // Scanner para capturar entrada do teclado
        Scanner entrada = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        // Variável para armazenar a opção escolhida no menu
        int indice;

        // Loop infinito que exibe o menu até o usuário escolher sair (opção 8)
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

            // Sair da aplicação se a opção 8 foi escolhida
            if (indice == 8) break;

            // Switch para processar cada opção do menu
            switch (indice) {
                // CASO 1: Cadastrar um novo livro
                case 1 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE LIVROS");
                    System.out.println("-------------------");

                    // Entrada do teclado fica "presa" do nextInt() anterior, usa nextLine() para limpar
                    entrada.nextLine();
                    System.out.print("Digite o titulo do livro:");
                    String titulo = entrada.nextLine();


                    System.out.println("Digite o autor do livro");
                    String autor = entrada.nextLine();

                    System.out.print("Digite o ISBN do livro:");
                    String isbn = entrada.nextLine();

                    Livro livro = new Livro(titulo, isbn, autor);

                    biblioteca.cadastrarLivro(livro);
                }

                // CASO 2: Cadastrar um novo usuário
                case 2 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE USUARIOS");
                    System.out.println("-------------------");

                    System.out.print("Digite o nome:");
                    String nome = entrada.nextLine();

                    System.out.print("Digite o ID:");
                    Integer id = entrada.nextInt();

                    Usuario usuario = new Usuario(nome, id);

                    biblioteca.cadastrarUsuario(usuario);
                }

                // CASO 3: Emprestar um livro a um usuário
                case 3 -> {
                    System.out.print("Digite o ID de quem fara o emprestimo do livro");
                    Integer id = entrada.nextInt();

                    Usuario usuario = biblioteca.buscarUsuario(id);

                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                    } else {
                        System.out.println("Usuario encontrado!");
                    }

                    //--------------------------------------------------
                    System.out.print("Digite o ISBN do livro que deseja emprestar: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);

                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                    } else  {
                        System.out.println("Livro encontrado!");
                    }

                    System.out.println(biblioteca.emprestarLivro(livro, usuario));

                }
                case 4 -> {
                    System.out.print("Digite o ID de quem fara o a devolucao do livro");
                    Integer id = entrada.nextInt();

                    Usuario usuario = biblioteca.buscarUsuario(id);

                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                    } else {
                        System.out.println("Usuario encontrado!");
                    }

                    //--------------------------------------------------
                    System.out.print("Digite o ISBN do livro que deseja devolver: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);

                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                    } else  {
                        System.out.println("Livro encontrado!");
                    }

                    System.out.println(biblioteca.devolverLivro(usuario, livro));
                }
                case 5 -> {
                    biblioteca.listarLivros();
                }
                case 6 -> {

                }
            }
        }

        // Fecha o Scanner ao sair da aplicação
        entrada.close();
    }
}
