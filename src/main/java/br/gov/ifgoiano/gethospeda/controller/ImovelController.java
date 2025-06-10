package br.gov.ifgoiano.gethospeda.controller;

import br.gov.ifgoiano.gethospeda.dto.*;
import br.gov.ifgoiano.gethospeda.service.ImovelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imovel")
@Tag(name = "Imóvel", description = "Endpoints para gerenciamento de imóveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar imóvel por ID",
            description = "Retorna os dados completos de um imóvel pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Imóvel encontrado",
                            content = @Content(schema = @Schema(implementation = ImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Erro interno")
            }
    )
    public ResponseEntity<ImovelCompletoDTO> findById(@PathVariable long id) {
        ImovelCompletoDTO imovel = imovelService.findById(id);
        if (imovel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imovel);
    }

    @GetMapping(value = "/quarto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar quartos de um imóvel",
            description = "Retorna todos os quartos relacionados ao imóvel com o ID informado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quartos encontrados",
                            content = @Content(schema = @Schema(implementation = QuartoResumoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<List<QuartoResumoDTO>> quartoFindByImovel(@PathVariable long id) {
        List<QuartoResumoDTO> quartos = imovelService.quartoFindByImovel(id);
        if (quartos == null || quartos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quartos);
    }

    @GetMapping(value = "/area/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar áreas de um imóvel",
            description = "Retorna todas as áreas de um imóvel pelo ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Áreas encontradas",
                            content = @Content(schema = @Schema(implementation = AreaResumoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<List<AreaResumoDTO>> areaFindByImovel(@PathVariable long id) {
        List<AreaResumoDTO> areas = imovelService.areaFindByImovel(id);
        if (areas == null || areas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(areas);
    }

    @GetMapping(value = "/servico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar serviços do imóvel",
            description = "Retorna todos os serviços disponíveis no imóvel com o ID fornecido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Serviços encontrados",
                            content = @Content(schema = @Schema(implementation = ServicoResumoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<List<ServicoResumoDTO>> servicoFindByImovel(@PathVariable long id) {
        List<ServicoResumoDTO> servicos = imovelService.servicoFindByImovel(id);
        if (servicos == null || servicos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicos);
    }

    @GetMapping(value = "/evento/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar eventos do imóvel",
            description = "Retorna todos os eventos registrados para o imóvel com o ID informado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Eventos encontrados",
                            content = @Content(schema = @Schema(implementation = EventoResumoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<List<EventoResumoDTO>> eventoFindByImovel(@PathVariable long id) {
        List<EventoResumoDTO> eventos = imovelService.eventoFindByImovel(id);
        if (eventos == null || eventos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventos);
    }

    @GetMapping(value = "/avaliacaoimovel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar avaliações do imóvel",
            description = "Retorna todas as avaliações registradas para o imóvel pelo ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliações encontradas",
                            content = @Content(schema = @Schema(implementation = AvaliacaoImovelResumoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<List<AvaliacaoImovelResumoDTO>> avaliacaoFindByImovel(@PathVariable long id) {
        List<AvaliacaoImovelResumoDTO> avaliacoes = imovelService.avaliacaoFindByImovel(id);
        if (avaliacoes == null || avaliacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Listar todos os imóveis",
            description = "Retorna uma lista de todos os imóveis cadastrados.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Imóveis listados",
                            content = @Content(schema = @Schema(implementation = ImovelResumoDTO.class)))
            }
    )
    public ResponseEntity<List<ImovelResumoDTO>> findAll() {
        List<ImovelResumoDTO> imoveis = imovelService.findAll();
        return ResponseEntity.ok(imoveis);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Cadastrar novo imóvel",
            description = "Cadastra um novo imóvel com base nos dados enviados em formato JSON.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Imóvel criado com sucesso",
                            content = @Content(schema = @Schema(implementation = ImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    public ResponseEntity<ImovelCompletoDTO> create(@RequestBody ImovelCreateDTO imovel) {
        ImovelCompletoDTO criado = imovelService.save(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Atualizar imóvel",
            description = "Atualiza os dados de um imóvel já cadastrado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Imóvel atualizado com sucesso",
                            content = @Content(schema = @Schema(implementation = ImovelCompletoDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos")
            }
    )
    public ResponseEntity<ImovelCompletoDTO> update(@RequestBody ImovelUpdateDTO imovel) {
        ImovelCompletoDTO atualizado = imovelService.update(imovel);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Remover imóvel",
            description = "Remove um imóvel cadastrado pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Imóvel removido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Imóvel não encontrado")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean deleted = imovelService.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
