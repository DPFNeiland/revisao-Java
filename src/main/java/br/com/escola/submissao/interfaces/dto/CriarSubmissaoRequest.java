package br.com.escola.submissao.interfaces.dto;

import jakarta.validation.constraints.NotNull;

public record CriarSubmissaoRequest(
        @NotNull Long estudanteId,
        @NotNull Long atividadeId
) {
}
