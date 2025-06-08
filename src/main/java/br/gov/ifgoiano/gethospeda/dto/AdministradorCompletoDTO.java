package br.gov.ifgoiano.gethospeda.dto;

public class AdministradorCompletoDTO {
    private String matricula;

    public AdministradorCompletoDTO() {
    }

    public AdministradorCompletoDTO(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}