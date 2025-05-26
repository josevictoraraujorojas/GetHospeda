package br.gov.ifgoiano.gethospeda.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@DiscriminatorValue("hospede")
public class Hospede extends Usuario{
    private String rg;
    @Column(name = "data_nascimento")
    private Date DataNascimento;
    @OneToMany(mappedBy = "hospede")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "hospede")
    private List<AvaliacaoCliente> avaliacoes;

    @OneToMany(mappedBy = "hospede")
    private List<CadastraEvento> eventos;

    @OneToMany(mappedBy = "hospede")
    private List<SolicitaServico> servicos;

    public Hospede() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<AvaliacaoCliente> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoCliente> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<CadastraEvento> getEventos() {
        return eventos;
    }

    public void setEventos(List<CadastraEvento> eventos) {
        this.eventos = eventos;
    }

    public List<SolicitaServico> getServicos() {
        return servicos;
    }

    public void setServicos(List<SolicitaServico> servicos) {
        this.servicos = servicos;
    }
}
