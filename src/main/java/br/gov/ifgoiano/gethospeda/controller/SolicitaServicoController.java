package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.service.SolicitaServicoService;
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
@RequestMapping("/solicitacoes-servico")
@Tag(name = "Solicitações de Serviço",description = "Endpoints sobre o gerenciamento de solicitações de serviço")
public class SolicitaServicoController {

    @Autowired
    private SolicitaServicoService service;

    @GetMapping
    @Operation(summary = "Encontrar todas as solicitações de serviços", description = "Encontrar todas as solicitações de serviços",
            tags = {"Solicitações de Serviço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServicoDTOOutput.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public List<SolicitaServicoDTOOutput> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{reservaId}/{servicoId}")
    public SolicitaServicoDTOOutput findById(@PathVariable Long reservaId, @PathVariable Long servicoId) {
        var dto = service.findById(reservaId, servicoId);
        return dto;
    }

    @PostMapping("/solicitar")
    @Operation(summary = "Criar uma nova solicitação de serviço", description = "Criar uma nova solicitação de serviço",
            tags = {"Solicitações de Serviço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServicoDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public SolicitaServicoDTO solicitar(@RequestBody @Valid SolicitaServicoDTO solicitacao) {
        return service.save(solicitacao);
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar uma solicitação de serviço", description = "Atualizar uma solicitação de serviço",
            tags = {"Solicitações de Serviço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = SolicitaServicoDTOOutput.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public SolicitaServicoDTO atualizar(@RequestBody @Valid SolicitaServicoDTO solicitacao) {
        return service.update(solicitacao);
    }

    @DeleteMapping("/deletar")
    @Operation(summary = "Deletar uma solicitação de serviço", description = "Deletar uma solicitação de serviço",
            tags = {"Solicitações de Serviço"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
                    @ApiResponse(description = "Internal Error", responseCode = "500"),
            })
    public void deletar(@RequestBody SolicitaServicoDTO solicitacao) {
        service.delete(solicitacao);
    }
}