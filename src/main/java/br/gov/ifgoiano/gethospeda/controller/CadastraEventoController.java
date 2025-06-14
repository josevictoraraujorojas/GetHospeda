package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.CadastraEventoDTO;
import br.gov.ifgoiano.gethospeda.dto.CadastraEventoDTOOutput;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.service.CadastraEventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastros-eventos")
@Tag(name = "CadastraEvento",description = "Endpoints sobre o cadastro em eventos")
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
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<CadastraEventoDTOOutput> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{eventoId}/{hospedeId}")
    @Operation(summary = "Mostrar o usuário cadastrado em um evento", description = "Mostrar o usuário cadastrado em um evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEventoDTOOutput.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public CadastraEventoDTOOutput findById(@PathVariable Long eventoId, @PathVariable Long hospedeId) {
        var dto = service.findById(eventoId, hospedeId);
        return dto;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastra em um evento", description = "Cadastra em um evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public CadastraEventoDTO cadastrar(@RequestBody CadastraEventoDTO cadastro) {
        return service.save(cadastro);
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar um cadastro em evento", description = "Atualizar um cadastro em evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CadastraEventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public CadastraEventoDTO atualizar(@RequestBody @Valid CadastraEventoDTO cadastraEventoDTO) {
        return service.update(cadastraEventoDTO);
    }

    @DeleteMapping("/deletar")
    @Operation(summary = "Deleta o cadastro em um evento", description = "Deleta o cadastro em um evento",
            tags = {"CadastraEvento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
                    @ApiResponse(description = "Internal Error", responseCode = "500"),
            })
    public void deletar(@RequestBody CadastraEventoDTO cadastro) {
        service.delete(cadastro);
    }
}