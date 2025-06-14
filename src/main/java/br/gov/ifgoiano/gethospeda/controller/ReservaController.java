package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.ReservaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaResumoDTO;
import br.gov.ifgoiano.gethospeda.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reserva", description = "Endpoints para gerenciamento de reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Operation(
            summary = "Buscar reserva por ID",
            description = "Retorna os dados completos de uma reserva específica pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva encontrada",
                            content = @Content(schema = @Schema(implementation = ReservaCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Reserva não encontrada",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/reservas/15"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/reservas/15"
                                }""")))
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservaCompletoDTO> findById(@PathVariable long id) {
        ReservaCompletoDTO dto = reservaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Listar todas as reservas",
            description = "Retorna uma lista com todas as reservas cadastradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de reservas",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReservaResumoDTO.class)))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/reservas"
                                }""")))
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservaResumoDTO>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @Operation(
            summary = "Cadastrar uma nova reserva",
            description = "Adiciona uma nova reserva ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Reserva criada com sucesso",
                            content = @Content(schema = @Schema(implementation = ReservaCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/reservas"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/reservas"
                                }""")))
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservaCompletoDTO> add(@RequestBody ReservaCreateDTO reserva) {
        ReservaCompletoDTO created = reservaService.save(reserva);
        if (created==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(created);
    }

    @Operation(
            summary = "Atualizar uma reserva existente",
            description = "Atualiza os dados de uma reserva previamente cadastrada",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso",
                            content = @Content(schema = @Schema(implementation = ReservaCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/reservas"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/reservas"
                                }""")))
            }
    )
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservaCompletoDTO> update(@RequestBody ReservaCompletoDTO reserva) {
        ReservaCompletoDTO updated = reservaService.update(reserva);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Remover uma reserva",
            description = "Remove uma reserva do sistema com base no ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Reserva removida com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Reserva não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try {
            reservaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
