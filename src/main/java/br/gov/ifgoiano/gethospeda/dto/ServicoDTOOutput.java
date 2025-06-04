package br.gov.ifgoiano.gethospeda.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class ServicoDTOOutput extends RepresentationModel<ServicoDTOOutput> implements Serializable {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private boolean disponibilidade;
    @JsonIgnore
    private ImovelResumoDTO imovel;

    public ServicoDTOOutput() {
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
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
        ServicoDTOOutput that = (ServicoDTOOutput) o;
        return id == that.id && Double.compare(preco, that.preco) == 0 && disponibilidade == that.disponibilidade && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(imovel, that.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, disponibilidade, imovel);
    }
}