package br.gov.ifgoiano.gethospeda.dto;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class ImovelResumoDTO extends RepresentationModel<ImovelResumoDTO> implements Serializable {
    private long id;
    private String titulo;
    private String descricao;

    public ImovelResumoDTO() {
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

}