package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class HospedeCompletoDTO extends UsuarioResumoDTO{
    private String rg;
    private Date dataNascimento;

    public HospedeCompletoDTO() {
    }

    public HospedeCompletoDTO(String rg, Date dataNascimento) {
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}