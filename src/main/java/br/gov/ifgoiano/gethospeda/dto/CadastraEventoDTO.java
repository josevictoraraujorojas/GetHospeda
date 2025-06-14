package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class CadastraEventoDTO extends RepresentationModel<SolicitaServicoDTO> implements Serializable {
    @NotNull(message = "O ID do evento é obrigatório")
    private Long eventoId;

    @NotNull(message = "O ID do hóspede é obrigatório")
    private Long hospedeId;

    @NotNull(message = "A data de cadastro é obrigatória")
    private Date dataCadastro;

    public CadastraEventoDTO() {
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