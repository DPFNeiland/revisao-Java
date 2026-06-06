package br.com.escola.submissao.infrastructure.repository;

import br.com.escola.submissao.domain.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository de infraestrutura.
 *
 * Responsável pela comunicação com o banco de dados.
 */
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
