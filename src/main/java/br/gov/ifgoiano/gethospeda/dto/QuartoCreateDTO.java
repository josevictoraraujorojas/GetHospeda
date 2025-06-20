package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuartoCreateDTO {

    @NotBlank(message = "O tipo do quarto é obrigatório")
    @Schema(description = "Tipo do quarto", example = "Suíte", required = true)
    private String tipo;

    @Min(value = 1, message = "A quantidade de camas deve ser pelo menos 1")
    @Schema(description = "Quantidade de camas no quarto", example = "2", required = true)
    private int quantidadeCamas;

    @Schema(description = "Indica se o quarto possui banheiro privativo", example = "true", required = true)
    private boolean banheiroPrivativo;

    @Min(value = 1, message = "A área em m² deve ser no mínimo 1")
    @Schema(description = "Área do quarto em metros quadrados", example = "25.5", required = true)
    private double areaM2;

    @NotNull(message = "O imóvel associado é obrigatório")
    @Schema(description = "Resumo do imóvel ao qual o quarto pertence", required = true)
    private ImovelResumoDTO imovel;

    @NotBlank(message = "A descrição do quarto é obrigatória")
    @Schema(description = "Descrição do quarto", example = "Quarto amplo e confortável", required = true)
    private String descricao;

    public QuartoCreateDTO() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(int quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public boolean isBanheiroPrivativo() {
        return banheiroPrivativo;
    }

    public void setBanheiroPrivativo(boolean banheiroPrivativo) {
        this.banheiroPrivativo = banheiroPrivativo;
    }

    public double getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(double areaM2) {
        this.areaM2 = areaM2;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
