package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

public class AvaliacaoImovelResumoDTO extends RepresentationModel<AvaliacaoImovelResumoDTO> {
    private long id;
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

    @Schema(hidden = true)  // oculta no Swagger UI
    // opcional: oculta no JSON (se quiser)
    public Links getLinks() {
        return super.getLinks();
    }
}
