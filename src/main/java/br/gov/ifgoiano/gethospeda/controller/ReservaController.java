package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.ReservaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaResumoDTO;
import br.gov.ifgoiano.gethospeda.model.Reserva;
import br.gov.ifgoiano.gethospeda.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaCompletoDTO findById(@PathVariable long id) {
        return reservaService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaResumoDTO> findAll() {
        return reservaService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReservaCompletoDTO add(@RequestBody ReservaCompletoDTO reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReservaCompletoDTO update(@RequestBody ReservaCompletoDTO reserva) {
        return reservaService.update(reserva);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        reservaService.delete(id);
    }
}
