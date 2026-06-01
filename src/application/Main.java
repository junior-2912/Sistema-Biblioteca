package application;

/**
 * Classe Principal do Sistema de Biblioteca
 * Responsável por gerenciar o menu interativo e a lógica principal da aplicação.
 *
 * Funcionalidades:
 * - Cadastro de livros no catálogo
 * - Cadastro de usuários
 * - Empréstimo e devolução de livros
 * - Listagem de livros, usuários e empréstimos
 */

import entities.Livro;
import entities.Usuario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner para capturar entrada do teclado
        Scanner entrada = new Scanner(System.in);

        // HashSet armazena livros únicos no catálogo (evita duplicatas)
        Set<Livro> livros = new HashSet<>();

        // HashSet armazena usuários únicos do sistema (evita duplicatas)
        Set<Usuario> usuarios = new HashSet<>();

        // HashMap mantém o controle de empréstimos: Usuário -> Conjunto de Livros Emprestados
        Map<Usuario, Set<Livro>> emprestimos = new HashMap<>();

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
                    System.out.print("Digite o titulo do livro:");
                    String titulo = entrada.nextLine();

                    System.out.println("Digite o autor do livro");
                    String autor = entrada.nextLine();

                    System.out.print("Digite o ISBN do livro:");
                    String isbn = entrada.nextLine();

                    // Tenta adicionar o livro. Se for bem-sucedido, Set retorna true (livro não existia)
                    if (livros.add(new Livro(titulo, isbn, autor))) {
                        System.out.println("Livro adicionado ao catalogo!");
                    } else {
                        // Se retornar false, o livro já estava cadastrado (duplicata)
                        System.out.println("Livro ja cadastrado!");
                    }
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

                    // Tenta adicionar o usuário. Set retorna true se for a primeira vez
                    if (usuarios.add(new Usuario(nome, id))) {
                        System.out.println("Usuario cadastrado com sucesso!");
                    } else {
                        // Se retornar false, o usuário já existe (ID duplicado)
                        System.out.println("Usuario ja existe!");
                    }
                }

                // CASO 3: Emprestar um livro a um usuário
                // ⚠️ AINDA EM DESENVOLVIMENTO - LÓGICA INCOMPLETA
                case 3 -> {
                    System.out.println("Digite o quem fara o emprestimo do livro");
                    String nome = entrada.nextLine();

                    // TODO: Implementar a lógica de empréstimo
                    // - Validar se o usuário existe
                    // - Validar se o livro existe
                    // - Atualizar o mapa de empréstimos
                }
            }
        }

        // Fecha o Scanner ao sair da aplicação
        entrada.close();
    }
}
