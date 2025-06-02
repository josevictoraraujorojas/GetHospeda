package br.gov.ifgoiano.gethospeda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AvaliacaoImovelCreateDTO {
    @NotNull
    private int nota;
    @NotBlank
    private String comentario;
    private double dataAvaliacao;
    @NotNull
    private ImovelResumoDTO imovel;

    public AvaliacaoImovelCreateDTO() {
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Double dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }
}
