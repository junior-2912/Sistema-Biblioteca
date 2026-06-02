package entities;

import java.util.Objects;

/**
 * Classe que representa um Usuário do sistema de biblioteca.
 *
 * Um usuário é identificado de forma única pelo seu ID. A classe armazena
 * informações básicas do usuário como nome e ID para acesso ao sistema.
 *
 * @author Sistema de Biblioteca
 * @version 1.0
 */
public class Usuario {
    private String nome;   // Nome completo do usuário
    private Integer id;    // Identificador único do usuário no sistema

    /**
     * Construtor do Usuário
     *
     * @param nome O nome completo do usuário
     * @param id O identificador único do usuário
     */
    public Usuario(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    /**
     * Retorna o nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o ID (identificador único) do usuário
     */
    public Integer getId() {
        return id;
    }

    /**
     * Compara dois usuários para verificar se são iguais.
     * Dois usuários são considerados iguais se tiverem o mesmo ID.
     * Isso garante que não haja dois usuários com IDs duplicados no sistema.
     *
     * @param o Objeto a ser comparado
     * @return true se os usuários têm o mesmo ID, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        // Compara apenas o ID para identificar usuários únicos
        return Objects.equals(id, usuario.id);
    }

    /**
     * Gera um código hash para o usuário baseado no ID.
     * Essencial para usar a classe em HashSet e HashMap.
     *
     * @return hash code baseado no ID
     */
    @Override
    public int hashCode() {
        // O hash é baseado unicamente no ID, pois o ID é o identificador único
        return Objects.hashCode(id);
    }
}
