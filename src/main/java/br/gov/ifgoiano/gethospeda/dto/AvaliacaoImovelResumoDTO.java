package br.gov.ifgoiano.gethospeda.dto;

public class AvaliacaoImovelResumoDTO {
    private long id;
    private int nota;

    public AvaliacaoImovelResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
