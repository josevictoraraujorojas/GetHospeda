package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class CadastraEvento {

    @EmbeddedId
    private CadastraEventoId id = new CadastraEventoId();

    @ManyToOne
    @MapsId("eventoId")
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;

    @ManyToOne
    @MapsId("hospedeId")
    @JoinColumn(name = "hospede_id", referencedColumnName = "id")
    private Hospede hospede;

    private Date dataCadastro;

    public CadastraEvento() {
    }

    public CadastraEventoId getId() {
        return id;
    }

    public void setId(CadastraEventoId id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
        if (evento != null) {
            this.id.setEventoId(evento.getId());
        }
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
        if (hospede != null) {
            this.id.setHospedeId(hospede.getId());
        }
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}