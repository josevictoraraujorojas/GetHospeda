package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class CadastraEventoDTOOutput extends RepresentationModel<CadastraEventoDTOOutput> implements Serializable {
    private Long eventoId;
    private Long hospedeId;
    private Date dataCadastro;

    public CadastraEventoDTOOutput() {
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(Long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }
}
