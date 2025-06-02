package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTOOutput;
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
    public List<SolicitaServicoDTOOutput> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    public SolicitaServicoDTO solicitar(@RequestBody SolicitaServicoDTO solicitacao) {
        return service.save(solicitacao);
    }

    @PutMapping
    public SolicitaServicoDTO atualizar(@RequestBody SolicitaServicoDTO solicitacao) {
        return service.update(solicitacao);
    }

    @DeleteMapping
    public void deletar(@RequestBody SolicitaServicoDTO solicitacao) {
        service.delete(solicitacao);
    }
}