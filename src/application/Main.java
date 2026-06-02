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

                    // Cria um novo objeto Livro com os dados fornecidos
                    Livro livro = new Livro(titulo, isbn, autor);

                    // Chama método da biblioteca para adicionar o livro ao catálogo
                    biblioteca.cadastrarLivro(livro);
                }

                // CASO 2: Cadastrar um novo usuário
                case 2 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE USUARIOS");
                    System.out.println("-------------------");

                    // Limpa o buffer de entrada
                    entrada.nextLine();
                    System.out.print("Digite o nome:");
                    String nome = entrada.nextLine();

                    System.out.print("Digite o ID:");
                    Integer id = entrada.nextInt();

                    // Cria um novo objeto Usuário com os dados fornecidos
                    Usuario usuario = new Usuario(nome, id);

                    // Chama método da biblioteca para adicionar o usuário ao sistema
                    biblioteca.cadastrarUsuario(usuario);
                }

                // CASO 3: Emprestar um livro a um usuário
                case 3 -> {
                    // Limpa o buffer e solicita o ID do usuário
                    entrada.nextLine();
                    System.out.print("Digite o ID de quem fara o emprestimo do livro: ");
                    Integer id = entrada.nextInt();

                    // Busca o usuário no sistema
                    Usuario usuario = biblioteca.buscarUsuario(id);

                    // Valida se o usuário existe
                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                    } else {
                        System.out.println("Usuario encontrado!");
                    }

                    // Solicita o ISBN do livro e busca no catálogo
                    entrada.nextLine();
                    System.out.print("Digite o ISBN do livro que deseja emprestar: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);

                    // Valida se o livro existe
                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                    } else  {
                        System.out.println("Livro encontrado!");
                    }

                    // Registra o empréstimo e exibe confirmação
                    System.out.println(biblioteca.emprestarLivro(livro, usuario));

                }
                // CASO 4: Devolver um livro
                case 4 -> {
                    // Limpa o buffer e solicita o ID do usuário
                    entrada.nextLine();
                    System.out.print("Digite o ID de quem fara a devolucao do livro: ");
                    Integer id = entrada.nextInt();

                    // Busca o usuário no sistema
                    Usuario usuario = biblioteca.buscarUsuario(id);

                    // Valida se o usuário existe
                    if (usuario == null) {
                        System.out.println("Usuario nao encontrado!");
                    } else {
                        System.out.println("Usuario encontrado!");
                    }

                    // Solicita o ISBN do livro e busca no catálogo
                    entrada.nextLine();
                    System.out.print("Digite o ISBN do livro que deseja devolver: ");
                    String isbn = entrada.nextLine();

                    Livro livro = biblioteca.buscarLivro(isbn);

                    // Valida se o livro existe
                    if (livro == null) {
                        System.out.println("Livro nao encontrado!");
                    } else  {
                        System.out.println("Livro encontrado!");
                    }

                    // Processa a devolução e exibe o resultado
                    System.out.println(biblioteca.devolverLivro(usuario, livro));
                }
                // CASO 5: Listar todos os livros do catálogo
                case 5 -> {
                    System.out.println("-------------------");
                    System.out.println("LISTAGEM DE LIVROS");
                    System.out.println("-------------------");
                    biblioteca.listarLivros();
                }

                // CASO 6: Listar todos os usuários cadastrados
                case 6 -> {
                    System.out.println("-------------------");
                    System.out.println("LISTAGEM DE USUARIOS");
                    System.out.println("-------------------");
                    // TODO: Implementar listagem de usuários
                }
            }
        }

        // Fecha o Scanner ao sair da aplicação
        entrada.close();
    }
}
