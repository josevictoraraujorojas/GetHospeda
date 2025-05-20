package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.Quarto;
import br.gov.ifgoiano.gethospeda.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/quarto")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Quarto findById(@PathVariable long id) {
        return quartoService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Quarto create(@RequestBody Quarto quarto) {
        return quartoService.save(quarto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Quarto update(@RequestBody Quarto quarto) {
        return quartoService.update(quarto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        quartoService.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Quarto> findAll(){
        return quartoService.findAll();
    }


}
