package br.com.escola.submissao.domain.valueobject;

import jakarta.persistence.Embeddable;

/**
 * Value Object que representa uma nota acadêmica.
 *
 * Regra de domínio: a nota deve estar entre 0 e 10.
 */
@Embeddable
public class Nota {

    private Long valor;

    protected Nota() {
        // Construtor protegido exigido pelo JPA.
    }

    public Nota(Long valor) {
        if (valor < 0 ) {
            throw new IllegalArgumentException("A nota deve ser maior ou igual a 0");
        }
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }
}
