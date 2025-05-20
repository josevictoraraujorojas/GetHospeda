package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.service.CadastraEventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastros-eventos")
public class CadastraEventoController {
    private final CadastraEventoService service;

    public CadastraEventoController(CadastraEventoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CadastraEvento> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    public CadastraEvento cadastrar(@RequestBody CadastraEvento cadastro) {
        return service.save(cadastro);
    }

    @DeleteMapping
    public void deletar(@RequestBody CadastraEvento cadastro) {
        service.delete(cadastro);
    }
}