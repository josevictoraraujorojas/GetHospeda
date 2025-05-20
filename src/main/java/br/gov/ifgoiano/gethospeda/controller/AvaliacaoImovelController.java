package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.AvaliacaoImovel;
import br.gov.ifgoiano.gethospeda.service.AvaliacaoImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacaoimovel")
public class AvaliacaoImovelController {
    @Autowired
    AvaliacaoImovelService avaliacaoImovelService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AvaliacaoImovel getAvaliacaoImovel(@PathVariable long id) {
        return avaliacaoImovelService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AvaliacaoImovel> getAvaliacaoImovels() {
        return avaliacaoImovelService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public AvaliacaoImovel save(@RequestBody AvaliacaoImovel avaliacaoImovel) {
        return avaliacaoImovelService.save(avaliacaoImovel);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public AvaliacaoImovel update(@RequestBody AvaliacaoImovel avaliacaoImovel) {
        return avaliacaoImovelService.update(avaliacaoImovel);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        avaliacaoImovelService.delete(id);
    }
}
