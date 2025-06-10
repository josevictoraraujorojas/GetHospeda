package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoResumoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoUpdateDTO;
import br.gov.ifgoiano.gethospeda.service.QuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
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
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuartoCompletoDTO> findById(@PathVariable Long id) {
        QuartoCompletoDTO dto = quartoService.findById(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "Listar todos os quartos",
            description = "Retorna uma lista com todos os quartos cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de quartos",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = QuartoResumoDTO.class)))),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuartoResumoDTO>> findAll() {
        return ResponseEntity.ok(quartoService.findAll());
    }

    @Operation(
            summary = "Cadastrar um novo quarto",
            description = "Adiciona um novo quarto ao sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Quarto criado com sucesso",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
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
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
            }
    )
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuartoCompletoDTO> update(@RequestBody QuartoUpdateDTO dto) {
        QuartoCompletoDTO updated = quartoService.update(dto);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "Remover um quarto",
            description = "Remove um quarto do sistema com base no ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Quarto removido com sucesso", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Quarto não encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = quartoService.deleteById(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
