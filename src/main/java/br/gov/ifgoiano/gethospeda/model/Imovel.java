package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "imovel")
public class Imovel {
    @Id
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Proprietario proprietario;
    @OneToMany(mappedBy = "imovel")
    List<Quarto> quartos = new ArrayList<>();
    @OneToMany(mappedBy = "imovel")
    List<Area> areas = new ArrayList<>();
    @OneToMany(mappedBy = "imovel")
    List<Servico> servicos = new ArrayList<>();
    @OneToMany(mappedBy = "imovel")
    List<Evento> eventos = new ArrayList<>();
    @OneToMany(mappedBy = "imovel")
    List<AvaliacaoImovel> avaliacoesImovel = new ArrayList<>();

    public Imovel() {
    }
}
