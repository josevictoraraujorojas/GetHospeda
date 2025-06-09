package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class ProprietarioCompletoDTO {
    private String cnpj;
    private Date dataNascimento;

    public ProprietarioCompletoDTO() {
    }

    public ProprietarioCompletoDTO(String cnpj, Date dataNascimento) {
        this.cnpj = cnpj;
        this.dataNascimento = dataNascimento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}