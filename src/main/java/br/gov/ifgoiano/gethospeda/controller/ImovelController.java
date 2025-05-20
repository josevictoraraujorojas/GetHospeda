package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.ImovelRepository;
import br.gov.ifgoiano.gethospeda.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Imovel findById(long id) {
        return imovelService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Imovel> findAll() {
        return imovelService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Imovel create(@RequestBody Imovel imovel) {
        return imovelService.save(imovel);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Imovel update(@RequestBody Imovel imovel) {
        return imovelService.update(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        imovelService.delete(id);
    }


}
