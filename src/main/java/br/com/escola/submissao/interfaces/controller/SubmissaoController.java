package br.com.escola.submissao.interfaces.controller;

import br.com.escola.submissao.application.service.SubmissaoService;
import br.com.escola.submissao.interfaces.dto.AvaliarSubmissaoRequest;
import br.com.escola.submissao.interfaces.dto.CriarSubmissaoRequest;
import br.com.escola.submissao.interfaces.dto.SubmissaoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissoes")
public class SubmissaoController {

    private final SubmissaoService service;

    public SubmissaoController(SubmissaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubmissaoResponse criar(@RequestBody @Valid CriarSubmissaoRequest request) {
        return SubmissaoResponse.fromEntity(service.criar(request));
    }

    @GetMapping
    public List<SubmissaoResponse> listar() {
        return service.listar()
                .stream()
                .map(SubmissaoResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public SubmissaoResponse buscarPorId(@PathVariable Long id) {
        return SubmissaoResponse.fromEntity(service.buscarPorId(id));
    }

    @PutMapping("/{id}/avaliar")
    public SubmissaoResponse avaliar(@PathVariable Long id,
                                     @RequestBody @Valid AvaliarSubmissaoRequest request) {



        return SubmissaoResponse.fromEntity(service.avaliar(id, request));
    }
}
