package br.gov.ifgoiano.gethospeda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Area implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Imovel imovel;
    private String horarioDisponivel;
    private String regrasDeUso;

    public Area() {
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

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public String getRegrasDeUso() {
        return regrasDeUso;
    }

    public void setRegrasDeUso(String regrasDeUso) {
        this.regrasDeUso = regrasDeUso;
    }
}
