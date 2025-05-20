package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "quarto")
public class Quarto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private int quantidadeCamas;
    private boolean banheiroPrivativo;
    private double areaM2;
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    private Imovel imovel;
    @OneToMany(mappedBy = "quarto")
    List<Reserva> reservas = new ArrayList<>();

    public Quarto() {
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

    public int getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(int quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public boolean isBanheiroPrivativo() {
        return banheiroPrivativo;
    }

    public void setBanheiroPrivativo(boolean banheiroPrivativo) {
        this.banheiroPrivativo = banheiroPrivativo;
    }

    public double getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(double areaM2) {
        this.areaM2 = areaM2;
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
}
