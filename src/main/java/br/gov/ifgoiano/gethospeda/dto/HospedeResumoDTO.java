package br.gov.ifgoiano.gethospeda.dto;

public class HospedeResumoDTO extends UsuarioResumoDTO{
    private String rg;

    public HospedeResumoDTO() {
    }

    public HospedeResumoDTO(String rg) {
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}