package br.com.escola.submissao.domain.entity;

import br.com.escola.submissao.domain.enums.StatusSubmissao;
import br.com.escola.submissao.domain.valueobject.Nota;
import br.com.escola.submissao.domain.valueobject.Pontuacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Entidade que representa o envio de uma atividade por um estudante.
 *
 * Esta classe concentra regras do domínio relacionadas ao ciclo de vida da submissão.
 */
@Entity
public class Submissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Estudante estudante;

    @ManyToOne(optional = false)
    private Atividade atividade;

    private LocalDateTime dataEnvio;

    @Embedded
    private Nota nota;

    private String comentarioProfessor;

    @Enumerated(EnumType.STRING)
    private StatusSubmissao status;


    protected Submissao() {
        // Construtor exigido pelo JPA.
    }

    public Submissao(Estudante estudante, Atividade atividade) {
        this.estudante = estudante;
        this.atividade = atividade;
        this.dataEnvio = LocalDateTime.now();
        this.status = StatusSubmissao.ENVIADA;
    }

    /**
     * Regra de negócio: ao avaliar uma submissão, a nota deve ser válida
     * e o comentário do professor não pode ser vazio.
     */
    public void avaliar(Nota nota, String comentarioProfessor) {
        if (comentarioProfessor == null || comentarioProfessor.isBlank()) {
            throw new IllegalArgumentException("Comentário do professor é obrigatório.");
        }
        this.nota = nota;
        this.comentarioProfessor = comentarioProfessor;
        this.status = StatusSubmissao.AVALIADA;
    }

    public Long getId() { return id; }
    public Estudante getEstudante() { return estudante; }
    public Atividade getAtividade() { return atividade; }
    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public Nota getNota() { return nota; }
    public String getComentarioProfessor() { return comentarioProfessor; }
    public StatusSubmissao getStatus() { return status; }
}
