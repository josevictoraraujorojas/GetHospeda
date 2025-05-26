package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.service.SolicitaServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes-servico")
public class SolicitaServicoController {

    @Autowired
    private SolicitaServicoService service;

    @GetMapping
    @Operation(summary = "Exibe todas as solicitações de serviços", description = "Exibe todas as solicitações de serviço",
            tags = {"SolicitaServicos"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServico.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<SolicitaServico> listarTodos() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastra uma solicitação de serviço", description = "Cadastra uma solicitação de serviço",
            tags = {"SolicitaServicos"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServico.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public SolicitaServico solicitar(@RequestBody SolicitaServico solicitacao) {
        return service.save(solicitacao);
    }

    @DeleteMapping
    @Operation(summary = "Deleta uma solicitação de serviço", description = "Deleta uma solicitação de serviço",
            tags = {"SolicitaServicos"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServico.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public void deletar(@RequestBody SolicitaServico solicitacao) {
        service.delete(solicitacao);
    }
}