package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.ReservaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaResumoDTO;
import br.gov.ifgoiano.gethospeda.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Reserva",description = "Gerenciamento de Reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar uma Reserva",
            description = "Buscar uma Reserva pelo id",
            tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ReservaCompletoDTO findById(@PathVariable long id) {
        return reservaService.findById(id);
    }
    @Operation(summary = "Buscar todas as Reserva",
            description = "Buscar todas as Reservas",
            tags = {"Reserva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
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
