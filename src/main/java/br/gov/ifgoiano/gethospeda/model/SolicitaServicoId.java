package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SolicitaServicoId implements Serializable {

    private Long reservaId;
    private Long servicoId;

    public SolicitaServicoId() {}

    public SolicitaServicoId(Long hospedeId, Long servicoId) {
        this.reservaId = hospedeId;
        this.servicoId = servicoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolicitaServicoId that)) return false;
        return Objects.equals(reservaId, that.reservaId) &&
                Objects.equals(servicoId, that.servicoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservaId, servicoId);
    }
}