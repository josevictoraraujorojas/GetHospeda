package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

@Schema(description = "DTO de resumo de avaliação de imóvel, contendo apenas o ID e a nota.")
public class AvaliacaoImovelResumoDTO extends RepresentationModel<AvaliacaoImovelResumoDTO> {

    @Schema(description = "ID da avaliação", example = "1")
    private long id;

    @Schema(description = "Nota atribuída na avaliação (de 1 a 5)", example = "5")
    private int nota;

    public AvaliacaoImovelResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }
}
