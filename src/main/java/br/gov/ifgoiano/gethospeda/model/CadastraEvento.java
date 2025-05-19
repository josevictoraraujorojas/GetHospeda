package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "cadastra_evento")
public class CadastraEvento{
    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "hospede_id",referencedColumnName = "id")
    private Hospede hospede;
    @Id
    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "evento_id",referencedColumnName = "id")
    private Evento evento;
    private Date dataCadastro;

    public CadastraEvento() {
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
