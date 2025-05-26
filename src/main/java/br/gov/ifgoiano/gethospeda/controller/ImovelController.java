package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.ImovelCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ImovelResumoDTO;
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
    public ImovelCompletoDTO findById(@PathVariable long id) {
        return imovelService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ImovelResumoDTO> findAll() {
        return imovelService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ImovelCompletoDTO create(@RequestBody ImovelCompletoDTO imovel) {
        return imovelService.save(imovel);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ImovelCompletoDTO update(@RequestBody ImovelCompletoDTO imovel) {
        return imovelService.update(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        imovelService.delete(id);
    }


}
