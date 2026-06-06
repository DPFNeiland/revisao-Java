package br.com.escola.submissao.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarAtividadeRequest(
        @NotBlank String titulo,
        String descricao,
        @NotNull LocalDate dataLimite,
        @NotNull Long pontuacaoMaxima
) {
}
