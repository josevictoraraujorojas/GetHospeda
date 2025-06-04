package br.gov.ifgoiano.gethospeda.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
    @PastOrPresent(message = "A data de solicitação não pode ser no futuro.")
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
}
