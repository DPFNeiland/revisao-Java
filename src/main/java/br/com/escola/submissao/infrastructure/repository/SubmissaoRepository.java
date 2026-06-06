package br.com.escola.submissao.infrastructure.repository;

import br.com.escola.submissao.domain.entity.Submissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissaoRepository extends JpaRepository<Submissao, Long> {
}
