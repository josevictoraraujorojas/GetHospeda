package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.service.SolicitaServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes-servico")
public class SolicitaServicoController {
    private final SolicitaServicoService service;

    public SolicitaServicoController(SolicitaServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SolicitaServico> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    public SolicitaServico solicitar(@RequestBody SolicitaServico solicitacao) {
        return service.save(solicitacao);
    }

    @DeleteMapping
    public void deletar(@RequestBody SolicitaServico solicitacao) {
        service.delete(solicitacao);
    }
}