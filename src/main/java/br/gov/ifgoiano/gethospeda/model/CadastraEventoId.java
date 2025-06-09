package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CadastraEventoId implements Serializable {

    private Long eventoId;
    private Long hospedeId;

    public CadastraEventoId() {}

    public CadastraEventoId(Long eventoId, Long hospedeId) {
        this.eventoId = eventoId;
        this.hospedeId = hospedeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadastraEventoId)) return false;
        CadastraEventoId that = (CadastraEventoId) o;
        return Objects.equals(eventoId, that.eventoId) &&
                Objects.equals(hospedeId, that.hospedeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoId, hospedeId);
    }
}