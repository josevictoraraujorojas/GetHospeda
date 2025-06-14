package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.AreaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaResumoDTO;
import br.gov.ifgoiano.gethospeda.service.AreaService;
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
@RequestMapping("/area")
@Tag(name = "Area", description = "Endpoints sobre o gerenciamento de área")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @Operation(
            summary = "Buscar área por ID",
            description = "Retorna os dados completos de uma área específica pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Área encontrada",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Área não encontrada",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/area/1"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/area/1"
                                }""")))
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaCompletoDTO> findById(@PathVariable long id) {
        AreaCompletoDTO dto = areaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Listar todas as áreas",
            description = "Retorna uma lista com todas as áreas cadastradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de áreas",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AreaResumoDTO.class)))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/area"
                                }""")))
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AreaResumoDTO>> findAll() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @Operation(
            summary = "Cadastrar uma nova área",
            description = "Adiciona uma nova área ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Área criada com sucesso",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/area"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/area"
                                }""")))
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaCompletoDTO> save(@RequestBody AreaCreateDTO area) {
        AreaCompletoDTO created = areaService.save(area);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(
            summary = "Atualizar área existente",
            description = "Atualiza os dados de uma área previamente cadastrada",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Área atualizada com sucesso",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:52:11.897+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/area"
                                }"""))),
                    @ApiResponse(responseCode = "404", description = "Área não encontrada",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:51:10.600+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/area"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-13T12:59:45.123+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/area"
                                }""")))
            }
    )
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaCompletoDTO> update(@RequestBody AreaCompletoDTO area) {
        AreaCompletoDTO updated = areaService.update(area);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Remover uma área",
            description = "Remove uma área do sistema com base no ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Área removida com sucesso", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Área não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean deleted = areaService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
