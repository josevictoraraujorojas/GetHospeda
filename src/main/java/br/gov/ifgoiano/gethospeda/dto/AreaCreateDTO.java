package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Dados necessários para cadastrar uma nova área em um imóvel, como piscina, churrasqueira ou salão de festas.")
public class AreaCreateDTO {

    @Schema(description = "Tipo da área", example = "Churrasqueira", required = true)
    @NotBlank
    private String tipo;

    @Schema(description = "Descrição da área", example = "Área com churrasqueira, pia e mesas para confraternizações.", required = true)
    @NotBlank
    private String descricao;

    @Schema(description = "Resumo do imóvel ao qual a área pertence", required = true)
    @NotNull
    private ImovelResumoDTO imovel;

    @Schema(
            description = "Horário disponível para uso da área, no formato 24h (HH:mm)",
            example = "08:00",
            pattern = "^([01]\\d|2[0-3]):[0-5]\\d$"
    )
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$")
    private String horarioDisponivel;

    @Schema(description = "Regras para utilização da área", example = "Não é permitido som alto após às 22h.", required = true)
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
