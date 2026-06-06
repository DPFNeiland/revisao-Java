package br.com.escola.submissao.application.service;

import br.com.escola.submissao.domain.entity.Atividade;
import br.com.escola.submissao.domain.valueobject.Pontuacao;
import br.com.escola.submissao.infrastructure.repository.AtividadeRepository;
import br.com.escola.submissao.interfaces.dto.CriarAtividadeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeRepository repository;

    public AtividadeService(AtividadeRepository repository) {
        this.repository = repository;
    }

    public Atividade criar(CriarAtividadeRequest request) {
        Atividade atividade = new Atividade(
                request.titulo(),
                request.descricao(),
                request.dataLimite(),
                new Pontuacao(request.pontuacaoMaxima())
        );
        return repository.save(atividade);
    }

    public List<Atividade> listar() {
        return repository.findAll();
    }
}
