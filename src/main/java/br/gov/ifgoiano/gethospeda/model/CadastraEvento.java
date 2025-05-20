package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@IdClass(CadastraEventoId.class)
public class CadastraEvento {

    @Id
    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;

    @Id
    @ManyToOne
    @JoinColumn(name = "hospede_id", referencedColumnName = "id")
    private Hospede hospede;

    private Date dataCadastro;

    public CadastraEvento() {
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}