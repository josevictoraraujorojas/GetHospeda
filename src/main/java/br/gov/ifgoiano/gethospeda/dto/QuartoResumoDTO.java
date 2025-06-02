package br.gov.ifgoiano.gethospeda.dto;

import java.io.Serializable;

public class QuartoResumoDTO implements Serializable {
    private long id;
    private String tipo;
    private String descricao;

    public QuartoResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}