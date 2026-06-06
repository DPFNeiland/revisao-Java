package br.com.escola.submissao.interfaces.controller;

import br.com.escola.submissao.application.service.EstudanteService;
import br.com.escola.submissao.domain.entity.Estudante;
import br.com.escola.submissao.interfaces.dto.CriarEstudanteRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    private final EstudanteService service;

    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criar(@RequestBody @Valid CriarEstudanteRequest request) {
        return service.criar(request);
    }

    @GetMapping
    public List<Estudante> listar() {
        return service.listar();
    }
}
