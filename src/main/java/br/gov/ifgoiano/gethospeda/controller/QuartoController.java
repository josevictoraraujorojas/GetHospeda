package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoResumoDTO;
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
    public QuartoCompletoDTO findById(@PathVariable long id) {
        return quartoService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuartoCompletoDTO create(@RequestBody QuartoCompletoDTO quarto) {
        return quartoService.save(quarto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuartoCompletoDTO update(@RequestBody QuartoCompletoDTO quarto) {
        return quartoService.update(quarto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        quartoService.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuartoResumoDTO> findAll(){
        return quartoService.findAll();
    }


}
