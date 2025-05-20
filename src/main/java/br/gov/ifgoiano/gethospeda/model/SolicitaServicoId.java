package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SolicitaServicoId implements Serializable {

    private Long hospedeId;
    private Long servicoId;

    public SolicitaServicoId() {}

    public SolicitaServicoId(Long hospedeId, Long servicoId) {
        this.hospedeId = hospedeId;
        this.servicoId = servicoId;
    }

    public Long getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(Long hospedeId) {
        this.hospedeId = hospedeId;
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
        return Objects.equals(hospedeId, that.hospedeId) &&
                Objects.equals(servicoId, that.servicoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospedeId, servicoId);
    }
}