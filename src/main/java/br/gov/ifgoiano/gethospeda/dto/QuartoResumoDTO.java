package br.gov.ifgoiano.gethospeda.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class QuartoResumoDTO extends RepresentationModel<QuartoResumoDTO> implements Serializable {

    @Schema(description = "Identificador único do quarto", example = "123")
    private long id;

    @Schema(description = "Tipo do quarto", example = "Suíte")
    private String tipo;

    @Schema(description = "Descrição do quarto", example = "Quarto amplo com varanda e vista para o jardim")
    private String descricao;

    public QuartoResumoDTO() {
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

    @Override
    @Schema(hidden = true)  // oculta os links na documentação Swagger
    public Links getLinks() {
        return super.getLinks();
    }
}
