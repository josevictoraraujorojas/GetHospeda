package br.gov.ifgoiano.gethospeda.dto;

import br.gov.ifgoiano.gethospeda.model.Imovel;

import java.util.Date;
import java.util.Objects;

public class EventoDTO {
    private long id;
    private String nome;
    private String local;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private int capacidade;
    private ImovelResumoDTO imovel;

    public EventoDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventoDTO eventoDTO = (EventoDTO) o;
        return id == eventoDTO.id && capacidade == eventoDTO.capacidade && Objects.equals(nome, eventoDTO.nome) && Objects.equals(local, eventoDTO.local) && Objects.equals(descricao, eventoDTO.descricao) && Objects.equals(dataInicio, eventoDTO.dataInicio) && Objects.equals(dataFim, eventoDTO.dataFim) && Objects.equals(imovel, eventoDTO.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, local, descricao, dataInicio, dataFim, capacidade, imovel);
    }
}
