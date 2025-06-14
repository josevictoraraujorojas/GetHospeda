package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SolicitaServicoDTO extends RepresentationModel<SolicitaServicoDTO> implements Serializable {

    @NotNull(message = "O ID da reserva é obrigatório.")
    private Long reservaId;

    @NotNull(message = "O ID do serviço é obrigatório.")
    private Long servicoId;

    @NotNull(message = "A data de solicitação é obrigatória.")
    @FutureOrPresent(message = "A data de solicitação não pode ser no passado.")
    private Date dataSolicitacao;

    public SolicitaServicoDTO() {
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SolicitaServicoDTO that = (SolicitaServicoDTO) o;
        return Objects.equals(reservaId, that.reservaId) && Objects.equals(servicoId, that.servicoId) && Objects.equals(dataSolicitacao, that.dataSolicitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservaId, servicoId, dataSolicitacao);
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }

}
