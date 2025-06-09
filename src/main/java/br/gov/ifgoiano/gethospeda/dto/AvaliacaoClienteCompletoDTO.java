package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class AvaliacaoClienteCompletoDTO {
    private int nota;
    private String comentario;
    private Date dataAvaliacao;
    private String regrasDeUso;

    public AvaliacaoClienteCompletoDTO() {
    }

    public AvaliacaoClienteCompletoDTO(int nota, String comentario, Date dataAvaliacao, String regrasDeUso) {
        this.nota = nota;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
        this.regrasDeUso = regrasDeUso;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getRegrasDeUso() {
        return regrasDeUso;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public void setRegrasDeUso(String regrasDeUso) {
        this.regrasDeUso = regrasDeUso;
    }
}