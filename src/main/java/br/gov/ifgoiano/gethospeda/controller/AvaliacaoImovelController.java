package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelResumoDTO;
import br.gov.ifgoiano.gethospeda.service.AvaliacaoImovelService;
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
@RequestMapping("/avaliacoesimovel")
@Tag(name = "Avaliação Imóvel", description = "Endpoints para gerenciamento de avaliações de imóveis")
public class AvaliacaoImovelController {

    @Autowired
    private AvaliacaoImovelService avaliacaoImovelService;

    @Operation(
            summary = "Buscar avaliação de imóvel por ID",
            description = "Retorna os dados completos de uma avaliação específica pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliação encontrada",
                            content = @Content(schema = @Schema(implementation = AvaliacaoImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-14T10:00:00.000+00:00",
                                  "status": 404,
                                  "error": "Not Found",
                                  "path": "/avaliacoesimovel/99"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-14T10:00:00.000+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/avaliacoesimovel/99"
                                }""")))
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvaliacaoImovelCompletoDTO> findById(@PathVariable long id) {
        AvaliacaoImovelCompletoDTO dto = avaliacaoImovelService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Listar todas as avaliações de imóveis",
            description = "Retorna uma lista com todas as avaliações cadastradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de avaliações",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AvaliacaoImovelResumoDTO.class)))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-14T10:00:00.000+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/avaliacoesimovel"
                                }""")))
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AvaliacaoImovelResumoDTO>> findAll() {
        return ResponseEntity.ok(avaliacaoImovelService.findAll());
    }

    @Operation(
            summary = "Cadastrar uma nova avaliação",
            description = "Adiciona uma nova avaliação ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Avaliação criada com sucesso",
                            content = @Content(schema = @Schema(implementation = AvaliacaoImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-14T10:00:00.000+00:00",
                                  "status": 400,
                                  "error": "Bad Request",
                                  "path": "/avaliacoesimovel"
                                }"""))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                                {
                                  "timestamp": "2025-06-14T10:00:00.000+00:00",
                                  "status": 500,
                                  "error": "Internal Server Error",
                                  "path": "/avaliacoesimovel"
                                }""")))
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvaliacaoImovelCompletoDTO> add(@RequestBody AvaliacaoImovelCreateDTO avaliacaoCreateDTO) {
        AvaliacaoImovelCompletoDTO created = avaliacaoImovelService.save(avaliacaoCreateDTO);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(
            summary = "Atualizar uma avaliação existente",
            description = "Atualiza os dados de uma avaliação previamente cadastrada",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliação atualizada com sucesso",
                            content = @Content(schema = @Schema(implementation = AvaliacaoImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                            content = @Content(mediaType = "application/json"))
            }
    )
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvaliacaoImovelCompletoDTO> update(@RequestBody AvaliacaoImovelCompletoDTO avaliacaoCompletoDTO) {
        AvaliacaoImovelCompletoDTO updated = avaliacaoImovelService.update(avaliacaoCompletoDTO);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Remover uma avaliação",
            description = "Remove uma avaliação do sistema com base no ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Avaliação removida com sucesso", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try {
            avaliacaoImovelService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
