package br.com.escola.submissao.domain.valueobject;


import jakarta.persistence.Embeddable;

/*

    entre 0 e 100

 */
@Embeddable
public class Pontuacao {

    private int pontuacao;

    protected Pontuacao() {
        // Construtor protegido exigido pelo JPA.
    }

    public Pontuacao(int pontuacao) {
        if (pontuacao < 0 || pontuacao > 100) {
            throw new IllegalArgumentException("A pontuacao deve estar entre 0 e 100.");
        }

        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}
