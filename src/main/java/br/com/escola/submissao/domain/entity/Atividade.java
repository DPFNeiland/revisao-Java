package br.com.escola.submissao.domain.entity;

import br.com.escola.submissao.domain.valueobject.Pontuacao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa uma atividade avaliativa.
 */
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDate dataLimite;

    @Embedded
    private Pontuacao pontuacaoMaxima;

    /**
     * Uma atividade pode receber várias submissões.
     */
    @OneToMany(mappedBy = "atividade")
    private List<Submissao> submissoes = new ArrayList<>();

    protected Atividade() {
        // Construtor exigido pelo JPA.
    }

    public Atividade(String titulo, String descricao, LocalDate dataLimite, Pontuacao pontuacaoMaxima) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título da atividade é obrigatório.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public Pontuacao getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }

}
