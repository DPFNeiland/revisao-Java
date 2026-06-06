package br.com.escola.submissao.infrastructure.repository;

import br.com.escola.submissao.domain.entity.Submissao;
import br.com.escola.submissao.interfaces.dto.SubmissaoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissaoRepository extends JpaRepository<Submissao, Long> {
}
