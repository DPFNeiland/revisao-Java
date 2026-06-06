package br.com.escola.submissao.domain.entity;

import br.com.escola.submissao.domain.valueobject.Email;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade do domínio.
 *
 * Um Estudante possui identidade própria, por isso é modelado como Entity.
 */
@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Email email;

    /**
     * Um estudante pode ter várias submissões.
     *
     * mappedBy indica que o relacionamento é controlado pelo atributo estudante
     * existente na entidade Submissao.
     */
    @OneToMany(mappedBy = "estudante")
    private List<Submissao> submissoes = new ArrayList<>();

    protected Estudante() {
        // Construtor exigido pelo JPA.
    }

    public Estudante(String nome, Email email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do estudante é obrigatório.");
        }
        this.nome = nome;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Email getEmail() { return email; }
}
