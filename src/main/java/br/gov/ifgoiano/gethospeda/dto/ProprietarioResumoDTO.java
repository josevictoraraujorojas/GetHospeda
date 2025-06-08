package br.gov.ifgoiano.gethospeda.dto;

public class ProprietarioResumoDTO {
    private String cnpj;

    public ProprietarioResumoDTO() {
    }

    public ProprietarioResumoDTO(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
