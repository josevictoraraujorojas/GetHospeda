package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "avaliacao_cliente")
public class AvaliacaoCliente implements Serializable {
    @Id
    private long id;
    private int nota;
    private String coentario;
    private Double dataAvaliacao;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "hospede_id",referencedColumnName = "id")
    private Hospede hospede;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "imovel_id",referencedColumnName = "id")
    private Proprietario proprietario;

    public AvaliacaoCliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getCoentario() {
        return coentario;
    }

    public void setCoentario(String coentario) {
        this.coentario = coentario;
    }

    public Double getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Double dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
