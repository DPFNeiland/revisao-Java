package br.com.escola.submissao.domain.valueobject;

import jakarta.persistence.Embeddable;

/**
 * Value Object que representa uma nota acadêmica.
 *
 * Regra de domínio: a nota deve estar entre 0 e 10.
 */
@Embeddable
public class Nota {

    private Double valor;

    protected Nota() {
        // Construtor protegido exigido pelo JPA.
    }

    public Nota(Double valor) {
        if (valor == null || valor < 0 || valor > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
}
