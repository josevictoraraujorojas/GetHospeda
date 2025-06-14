package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detalhamento completo da área disponível em um imóvel, como piscina, salão de festas ou churrasqueira.")
public class AreaCompletoDTO {

    @Schema(description = "Identificador único da área", example = "1")
    private long id;

    @Schema(description = "Tipo da área", example = "Piscina")
    private String tipo;

    @Schema(description = "Descrição da área", example = "Piscina semiolímpica aquecida, disponível para todos os hóspedes.")
    private String descricao;

    @Schema(description = "Resumo das informações do imóvel ao qual a área pertence")
    private ImovelResumoDTO imovel;

    @Schema(description = "Horário disponível para uso da área", example = "08:00 às 22:00")
    private String horarioDisponivel;

    @Schema(description = "Regras para uso da área", example = "É obrigatório o uso de trajes de banho. Não é permitido consumir bebidas de vidro.")
    private String regrasDeUso;

    public AreaCompletoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
