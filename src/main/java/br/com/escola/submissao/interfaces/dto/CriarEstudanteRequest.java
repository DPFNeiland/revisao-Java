package br.com.escola.submissao.interfaces.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO de entrada para cadastro de estudante.
 *
 * DTO evita que o Controller receba diretamente uma Entity.
 */
public record CriarEstudanteRequest(
        @NotBlank String nome,
        @Email @NotBlank String email
) {
}
