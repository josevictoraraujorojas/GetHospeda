package br.gov.ifgoiano.gethospeda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AreaCreateDTO {
    @NotBlank
    private String tipo;
    @NotBlank
    private String descricao;
    @NotNull
    private ImovelResumoDTO imovel;
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$\n")
    private String horarioDisponivel;
    @NotBlank
    private String regrasDeUso;

    public AreaCreateDTO() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public String getRegrasDeUso() {
        return regrasDeUso;
    }

    public void setRegrasDeUso(String regrasDeUso) {
        this.regrasDeUso = regrasDeUso;
    }
}
