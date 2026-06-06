package br.com.escola.submissao.infrastructure.repository;

import br.com.escola.submissao.domain.entity.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
