package br.com.escola.submissao.interfaces.dto;

import br.com.escola.submissao.domain.entity.Submissao;
import br.com.escola.submissao.domain.enums.StatusSubmissao;

import java.time.LocalDateTime;

/**
 * DTO de saída para devolver informações organizadas ao cliente da API.
 */
public record SubmissaoResponse(
        Long id,
        String estudante,
        String emailEstudante,
        String atividade,
        LocalDateTime dataEnvio,
        Long notamaxima,
        Long nota,
        String comentarioProfessor,
        StatusSubmissao status


) {
    public static SubmissaoResponse fromEntity(Submissao submissao) {
        Long valorNota = submissao.getNota() == null ? null : submissao.getNota().getValor();

        return new SubmissaoResponse(
                submissao.getId(),
                submissao.getEstudante().getNome(),
                submissao.getEstudante().getEmail().getValor(),
                submissao.getAtividade().getTitulo(),
                submissao.getDataEnvio(),
                submissao.getAtividade().getPontuacaoMaxima().getPontuacao(),
                valorNota,
                submissao.getComentarioProfessor(),
                submissao.getStatus()
        );
    }
}
