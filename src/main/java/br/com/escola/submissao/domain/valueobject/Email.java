package br.com.escola.submissao.domain.valueobject;

import jakarta.persistence.Embeddable;

/**
 * Value Object que representa um e-mail.
 *
 * Em DDD, Value Objects representam conceitos do domínio que não possuem identidade própria,
 * mas possuem regras de validação e significado para o negócio.
 */
@Embeddable
public class Email {

    private String valor;

    protected Email() {
        // Construtor protegido exigido pelo JPA.
    }

    public Email(String valor) {
        if (valor == null || valor.isBlank() || !valor.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
