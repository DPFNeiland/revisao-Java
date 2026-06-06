package br.com.escola.submissao.application.service;

import br.com.escola.submissao.domain.entity.Estudante;
import br.com.escola.submissao.domain.valueobject.Email;
import br.com.escola.submissao.infrastructure.repository.EstudanteRepository;
import br.com.escola.submissao.interfaces.dto.CriarEstudanteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de aplicação.
 *
 * O Service coordena casos de uso e evita que regras fiquem diretamente no Controller.
 */
@Service
public class EstudanteService {

    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante criar(CriarEstudanteRequest request) {
        Estudante estudante = new Estudante(
                request.nome(),
                new Email(request.email())
        );
        return repository.save(estudante);
    }

    public List<Estudante> listar() {
        return repository.findAll();
    }
}
