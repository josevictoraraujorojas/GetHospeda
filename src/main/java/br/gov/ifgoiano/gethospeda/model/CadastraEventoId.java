package br.gov.ifgoiano.gethospeda.model;

import java.io.Serializable;
import java.util.Objects;

public class CadastraEventoId implements Serializable {
    private Long evento;
    private Long hospede;

    public CadastraEventoId() {}

    public CadastraEventoId(Long evento, Long hospede) {
        this.evento = evento;
        this.hospede = hospede;
    }

    // equals e hashCode são OBRIGATÓRIOS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadastraEventoId)) return false;
        CadastraEventoId that = (CadastraEventoId) o;
        return Objects.equals(evento, that.evento) && Objects.equals(hospede, that.hospede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evento, hospede);
    }
}