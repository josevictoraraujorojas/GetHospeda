package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.service.CadastraEventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastros-eventos")
public class CadastraEventoController {

    @Autowired
    private CadastraEventoService service;


    @GetMapping
    @Operation(summary = "Mostrar todos os cadastros nos eventos", description = "Mostrar todos os cadastros nos eventos",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEvento.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<CadastraEvento> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastra em um evento", description = "Cadastra em um evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEvento.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public CadastraEvento cadastrar(@RequestBody CadastraEvento cadastro) {
        return service.save(cadastro);
    }

    @DeleteMapping
    @Operation(summary = "Deleta o cadastro em um evento", description = "Deleta o cadastro em um evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEvento.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public void deletar(@RequestBody CadastraEvento cadastro) {
        service.delete(cadastro);
    }
}