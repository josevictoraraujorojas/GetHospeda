package br.gov.ifgoiano.gethospeda.dto;

import java.io.Serializable;
import java.util.List;

public class ImovelCompletoDTO implements Serializable {
    private long id;
    private String titulo;
    private String descricao;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private float precoDiaria;
    private String politicaDeCancelamento;
    private String status;
    private List<QuartoResumoDTO> quartos;
    private List<AreaResumoDTO> areas;
    private List<ServicoResumoDTO> servicos;
    private List<EventoResumoDTO> eventos;

    public ImovelCompletoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public float getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(float precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public String getPoliticaDeCancelamento() {
        return politicaDeCancelamento;
    }

    public void setPoliticaDeCancelamento(String politicaDeCancelamento) {
        this.politicaDeCancelamento = politicaDeCancelamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuartoResumoDTO> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<QuartoResumoDTO> quartos) {
        this.quartos = quartos;
    }

    public List<AreaResumoDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaResumoDTO> areas) {
        this.areas = areas;
    }

    public List<ServicoResumoDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoResumoDTO> servicos) {
        this.servicos = servicos;
    }

    public List<EventoResumoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoResumoDTO> eventos) {
        this.eventos = eventos;
    }
}
