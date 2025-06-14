package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.EventoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.EventoDTO;
import br.gov.ifgoiano.gethospeda.dto.EventoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.service.EventoService;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@Tag(name = "Evento",description = "Endpoints sobre o gerenciamento de eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    @Operation(summary = "Encontrar todos os eventos", description = "Encontrar todos os eventos",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EventoDTOOutput.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<EventoDTOOutput> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontra evento específico", description = "Encontra evento específico",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EventoDTOOutput.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public EventoDTOOutput buscarPorId(@PathVariable Long id) {
        EventoDTOOutput evento = service.findById(id);
        return DataMapper.parseObject(evento, EventoDTOOutput.class);
    }

    @GetMapping("/imovel/{imovelId}")
    @Operation(summary = "Encontra evento por imóvel", description = "Encontra evento por imóvel",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<EventoDTOOutput> getEventosByImovelId(@PathVariable int imovelId) {
        return service.findByImovelId(imovelId);
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Cadastrar evento", description = "Cadastrar evento",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public EventoDTO salvar(@RequestBody @Valid EventoCreateDTO eventoDTO) {
        return service.save(eventoDTO);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar evento", description = "Atualizar evento",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = EventoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EventoDTO eventoDTO) {
        try {
            eventoDTO.setId(id);
            return ResponseEntity.ok(service.update(eventoDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar evento", description = "Deletar evento",
            tags = {"Evento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
                    @ApiResponse(description = "Internal Error", responseCode = "500"),
            })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.delete(id); // delete já lança a exceção se não existir
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}