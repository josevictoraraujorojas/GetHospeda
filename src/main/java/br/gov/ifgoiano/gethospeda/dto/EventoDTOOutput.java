package br.gov.ifgoiano.gethospeda.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.Objects;

public class EventoDTOOutput extends RepresentationModel<EventoDTOOutput> {

    private long id;
    private String nome;
    private String local;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private int capacidade;
    @JsonIgnore
    private ImovelResumoDTO imovel;

    public EventoDTOOutput() {}

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
        EventoDTOOutput that = (EventoDTOOutput) o;
        return id == that.id && capacidade == that.capacidade && Objects.equals(nome, that.nome) && Objects.equals(local, that.local) && Objects.equals(descricao, that.descricao) && Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataFim, that.dataFim) && Objects.equals(imovel, that.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, local, descricao, dataInicio, dataFim, capacidade, imovel);
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }
}
