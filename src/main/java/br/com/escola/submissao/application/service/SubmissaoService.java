package br.com.escola.submissao.application.service;

import br.com.escola.submissao.domain.entity.Atividade;
import br.com.escola.submissao.domain.entity.Estudante;
import br.com.escola.submissao.domain.entity.Submissao;
import br.com.escola.submissao.domain.enums.StatusSubmissao;
import br.com.escola.submissao.domain.valueobject.Nota;
import br.com.escola.submissao.infrastructure.repository.AtividadeRepository;
import br.com.escola.submissao.infrastructure.repository.EstudanteRepository;
import br.com.escola.submissao.infrastructure.repository.SubmissaoRepository;
import br.com.escola.submissao.interfaces.dto.AvaliarSubmissaoRequest;
import br.com.escola.submissao.interfaces.dto.CriarSubmissaoRequest;
import br.com.escola.submissao.interfaces.dto.SubmissaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service principal do caso de uso de submissões.
 *
 * Aqui ficam regras de aplicação, como verificar se estudante e atividade existem.
 */
@Service
public class SubmissaoService {

    private final SubmissaoRepository submissaoRepository;
    private final EstudanteRepository estudanteRepository;
    private final AtividadeRepository atividadeRepository;

    public SubmissaoService(SubmissaoRepository submissaoRepository,
                            EstudanteRepository estudanteRepository,
                            AtividadeRepository atividadeRepository) {
        this.submissaoRepository = submissaoRepository;
        this.estudanteRepository = estudanteRepository;
        this.atividadeRepository = atividadeRepository;
    }

    public Submissao criar(CriarSubmissaoRequest request) {
        Estudante estudante = estudanteRepository.findById(request.estudanteId())
                .orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado."));

        Atividade atividade = atividadeRepository.findById(request.atividadeId())
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada."));

        Submissao submissao = new Submissao(estudante, atividade);
        return submissaoRepository.save(submissao);
    }

    public List<Submissao> listar() {
        return submissaoRepository.findAll();
    }

    public Submissao buscarPorId(Long id) {
        return submissaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Submissão não encontrada."));
    }

    public Submissao avaliar(Long id, AvaliarSubmissaoRequest request) {
        Submissao submissao = buscarPorId(id);

        if (submissao.getStatus() != StatusSubmissao.ENVIADA){
            throw new IllegalArgumentException("Submissão já avaliada.");
        }

        if (request.nota() > submissao.getAtividade().getPontuacaoMaxima().getPontuacao()) {
            throw new IllegalArgumentException("Nota maior que a pontuação máxima do teste");
        }


        submissao.avaliar(new Nota(request.nota()), request.comentarioProfessor());
        return submissaoRepository.save(submissao);
    }
}
