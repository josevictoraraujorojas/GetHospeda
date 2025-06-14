package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.*;
import br.gov.ifgoiano.gethospeda.service.QuartoService;
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
@RequestMapping("/quartos")
@Tag(name = "Quarto", description = "Endpoints para gerenciamento de quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @Operation(
            summary = "Buscar quarto por ID",
            description = "Retorna os dados completos de um quarto específico pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quarto encontrado",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/quartos/25"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/quartos/25"
                                }""")))
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuartoCompletoDTO> findById(@PathVariable Long id) {
        QuartoCompletoDTO dto = quartoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Listar todos os quartos",
            description = "Retorna uma lista com todos os quartos cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de quartos",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = QuartoResumoDTO.class)))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/quartos"
                                }""")))
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuartoResumoDTO>> findAll() {
        return ResponseEntity.ok(quartoService.findAll());
    }

    @Operation(
            summary = "Listar todos as reservas",
            description = "Retorna uma lista com todas as reservas de um quarto",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de reservas",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = QuartoResumoDTO.class)))),
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/quartos/25/reserva"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/quartos/25/reserva"
                                }""")))
            }
    )
    @GetMapping(value = "/{id}/reserva", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservaResumoDTO>> findAllReservas(@PathVariable long id) {
        List<ReservaResumoDTO> dto = quartoService.findAllReservas(id);

        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Cadastrar um novo quarto",
            description = "Adiciona um novo quarto ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Quarto criado com sucesso",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/quartos"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/quartos"
                                }""")))
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuartoCompletoDTO> create(@RequestBody QuartoCreateDTO dto) {
        QuartoCompletoDTO created = quartoService.save(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(
            summary = "Atualizar quarto existente",
            description = "Atualiza os dados de um quarto previamente cadastrado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quarto atualizado com sucesso",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/quartos"
                                }"""))),
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/quartos"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/quartos"
                                }""")))
            }
    )
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuartoCompletoDTO> update(@RequestBody QuartoUpdateDTO dto) {
        QuartoCompletoDTO updated = quartoService.update(dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Remover um quarto",
            description = "Remove um quarto do sistema com base no ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Quarto removido com sucesso", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = quartoService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
