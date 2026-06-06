package br.com.escola.submissao.interfaces.controller;

import br.com.escola.submissao.application.service.AtividadeService;
import br.com.escola.submissao.domain.entity.Atividade;
import br.com.escola.submissao.interfaces.dto.CriarAtividadeRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    private final AtividadeService service;

    public AtividadeController(AtividadeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atividade criar(@RequestBody @Valid CriarAtividadeRequest request) {
        return service.criar(request);
    }

    @GetMapping
    public List<Atividade> listar() {
        return service.listar();
    }
}
