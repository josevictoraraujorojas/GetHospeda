package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.AreaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaResumoDTO;
import br.gov.ifgoiano.gethospeda.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AreaCompletoDTO findById(@PathVariable long id) {
        return areaService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AreaResumoDTO> findAll() {
        return areaService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public AreaCompletoDTO save(@RequestBody AreaCompletoDTO area) {
        return areaService.save(area);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AreaCompletoDTO update(@RequestBody AreaCompletoDTO area) {
        return areaService.update(area);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        areaService.deleteById(id);
    }



}
