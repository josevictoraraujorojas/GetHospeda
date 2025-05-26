package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class SolicitaServico implements Serializable {

    @EmbeddedId
    private SolicitaServicoId id;

    @ManyToOne
    @MapsId("hospedeId")
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    @ManyToOne
    @MapsId("servicoId")
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;

    public SolicitaServico() {
    }

    public SolicitaServicoId getId() {
        return id;
    }

    public void setId(SolicitaServicoId id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
