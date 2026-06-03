package entities;

import java.util.Objects;

/**
 * Representa um usuário do sistema de biblioteca.
 * Identificado de forma única pelo ID para garantir unicidade no sistema.
 */
public class Usuario {
    private String nome;
    private Integer id;

    /**
     * Construtor do Usuário
     */
    public Usuario(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Dois usuários são iguais se tiverem o mesmo ID.
     * Garante unicidade de IDs no sistema.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    /**
     * Hash baseado no ID para uso em HashSet e HashMap.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return nome + ", ID: " + id;
    }
}
