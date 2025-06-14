package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SolicitaServicoDTOOutput extends RepresentationModel<SolicitaServicoDTOOutput> implements Serializable {

    private Long reservaId;

    private Long servicoId;

    private Date dataSolicitacao;

    public SolicitaServicoDTOOutput() {
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
        SolicitaServicoDTOOutput that = (SolicitaServicoDTOOutput) o;
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
