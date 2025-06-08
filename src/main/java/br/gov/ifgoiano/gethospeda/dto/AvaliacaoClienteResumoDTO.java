package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class AvaliacaoClienteResumoDTO {
    private int nota;
    private Date dataAvaliacao;

    public AvaliacaoClienteResumoDTO() {
    }

    public AvaliacaoClienteResumoDTO(int nota, Date dataAvaliacao) {
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
