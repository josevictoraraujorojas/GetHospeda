package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.AreaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaResumoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@Tag(name = "Area",description = "Endpoints sobre o gerenciamento de area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar area", description = "Buscar uma area pelo id",
            tags = {"Area"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public AreaCompletoDTO findById(@PathVariable long id) {
        return areaService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar todas as areas", description = "Buscar todas as areas",
            tags = {"Area"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AreaResumoDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<AreaResumoDTO> findAll() {
        return areaService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Adicionar uma nova Area",
            description = "Adicionar um novo Area utilizando json!",
            tags = {"Area"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public AreaCompletoDTO save(@RequestBody AreaCreateDTO area) {
        return areaService.save(area);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar uma Area",
            description = "Atualizar uma Area utilizando json",
            tags = {"Area"},
            responses = {
                    @ApiResponse(description = "Atualizado", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AreaCompletoDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public AreaCompletoDTO update(@RequestBody AreaCompletoDTO area) {
        return areaService.update(area);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar uma area",
            description = "Deletar uma area pelo id",
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
        areaService.deleteById(id);
    }



}
