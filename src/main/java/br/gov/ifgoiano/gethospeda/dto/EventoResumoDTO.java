package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(description = "Resumo de informações sobre um evento realizado no hotel")
public class EventoResumoDTO extends RepresentationModel<EventoResumoDTO> {

    @Schema(description = "Identificador único do evento", example = "101")
    private long id;

    @Schema(description = "Nome do evento", example = "Show de Forró com Banda Xote Bom")
    private String nome;

    @Schema(description = "Descrição breve do evento", example = "Apresentação ao vivo da banda Xote Bom na área de lazer do hotel com churrasco incluso.")
    private String descricao;

    @Schema(description = "Data e hora de início do evento", example = "2025-07-10T20:00:00Z", type = "string", format = "date-time")
    private Date dataInicio;

    public EventoResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
