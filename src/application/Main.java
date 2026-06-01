package application;


import entities.Livro;
import entities.Usuario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Set<Livro> livros = new HashSet<>();

        Set<Usuario> usuarios = new HashSet<>();

        Map<Usuario, Set<Livro>> emprestimos = new HashMap<>();

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
            indice = entrada.nextInt();

            if (indice == 8) break;

            switch (indice) {
                case 1 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE LIVROS");
                    System.out.println("-------------------");

                    System.out.print("Digite o titulo do livro:");
                    String titulo = entrada.nextLine();

                    System.out.println("Digite o autor do livro");
                    String autor = entrada.nextLine();

                    System.out.print("Digite o ISBN do livro:");
                    String isbn = entrada.nextLine();

                    if (livros.add(new Livro(titulo, isbn, autor))) {
                        System.out.println("Livro adicionado ao catalogo!");
                    } else {
                        System.out.println("Livro ja cadastrado!");
                    }
                }
                case 2 -> {
                    System.out.println("-------------------");
                    System.out.println("CADASTRO DE USUARIOS");
                    System.out.println("-------------------");

                    System.out.print("Digite o nome:");
                    String nome = entrada.nextLine();

                    System.out.print("Digite o ID:");
                    Integer id = entrada.nextInt();

                    if (usuarios.add(new Usuario(nome, id))) {
                        System.out.println("Usuario cadastrado com sucesso!");
                    } else {
                        System.out.println("Usuario ja existe!");
                    }
                }
                case 3 -> {
                    System.out.println("Digite o quem fara o emprestimo do livro");
                    String nome = entrada.nextLine();


                }
            }
        }


    }
}
