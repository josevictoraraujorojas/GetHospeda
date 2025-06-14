package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Schema(description = "Resumo dos dados do imóvel, contendo informações básicas")
public class ImovelResumoDTO extends RepresentationModel<ImovelResumoDTO> implements Serializable {

    @Schema(description = "Identificador único do imóvel", example = "1")
    private long id;

    @Schema(description = "Título do imóvel", example = "Apartamento Central")
    private String titulo;

    @Schema(description = "Descrição resumida do imóvel", example = "Apartamento bem localizado, ideal para viajantes.")
    private String descricao;

    public ImovelResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Schema(hidden = true)  // oculta no Swagger UI
    // opcional: oculta no JSON (se quiser)
    public Links getLinks() {
        return super.getLinks();
    }
}
