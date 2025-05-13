package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.io.Serializable;
import java.util.Date;

@Entity
public class SolicitaServico implements Serializable {
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "hospede_id", referencedColumnName = "id")
    private Hospede hospede;
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "servico_id", referencedColumnName = "id")
    private Servico servico;
    private Date dataSolicitacao;

    public SolicitaServico() {
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
