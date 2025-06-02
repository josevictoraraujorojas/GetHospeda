package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoResumoDTO;
import br.gov.ifgoiano.gethospeda.model.Quarto;
import br.gov.ifgoiano.gethospeda.service.QuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/quarto")
@Tag(name = "Quarto",description = "Endpoints sobre o gerenciamento de quartos")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar uma pessoa", description = "Buscar uma pesso pelo id",
            tags = {"Quarto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public QuartoCompletoDTO findById(@PathVariable long id) {
        return quartoService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Adicionar um novo Quarto",
            description = "Adicionar um novo Quarto utilizando json!",
            tags = {"Quarto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public QuartoCompletoDTO create(@RequestBody QuartoCreateDTO quarto) {
        return quartoService.save(quarto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar um Quarto",
            description = "Atualizar um quarto utilizando json",
            tags = {"Quarto"},
            responses = {
                    @ApiResponse(description = "Atualizado", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = QuartoCompletoDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public QuartoCompletoDTO update(@RequestBody QuartoCompletoDTO quarto) {
        return quartoService.update(quarto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um quarto",
            description = "Deletar um quarto pelo id",
            tags = {"Quarto"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public void delete(@PathVariable long id) {
        quartoService.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar todos os Quartos", description = "Buscar todos os Quartos",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = QuartoResumoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<QuartoResumoDTO> findAll(){
        return quartoService.findAll();
    }


}
