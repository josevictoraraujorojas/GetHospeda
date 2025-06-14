package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

@Schema(description = "Resumo de uma área comum cadastrada em um imóvel, como churrasqueira, piscina ou salão.")
public class AreaResumoDTO extends RepresentationModel<AreaResumoDTO> {

    @Schema(description = "Identificador único da área", example = "101")
    private long id;

    @Schema(description = "Tipo da área", example = "Piscina")
    private String tipo;

    @Schema(description = "Descrição breve da área", example = "Piscina olímpica com área de descanso e guarda-vidas.")
    private String descricao;

    public AreaResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
