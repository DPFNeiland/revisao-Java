package br.com.escola.submissao.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliarSubmissaoRequest(
        @NotNull Double nota,
        @NotBlank String comentarioProfessor
) {
}
