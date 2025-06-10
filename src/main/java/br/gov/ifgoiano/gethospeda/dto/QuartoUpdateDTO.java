package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class QuartoUpdateDTO {

    @Schema(description = "Identificador único do quarto (geralmente omitido na criação)", example = "0")
    private long id;

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

    @NotBlank(message = "A descrição do quarto é obrigatória")
    @Schema(description = "Descrição do quarto", example = "Quarto amplo e confortável", required = true)
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "O tipo do quarto é obrigatório") String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank(message = "O tipo do quarto é obrigatório") String tipo) {
        this.tipo = tipo;
    }

    @Min(value = 1, message = "A quantidade de camas deve ser pelo menos 1")
    public int getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(@Min(value = 1, message = "A quantidade de camas deve ser pelo menos 1") int quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public boolean isBanheiroPrivativo() {
        return banheiroPrivativo;
    }

    public void setBanheiroPrivativo(boolean banheiroPrivativo) {
        this.banheiroPrivativo = banheiroPrivativo;
    }

    @Min(value = 1, message = "A área em m² deve ser no mínimo 1")
    public double getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(@Min(value = 1, message = "A área em m² deve ser no mínimo 1") double areaM2) {
        this.areaM2 = areaM2;
    }

    public @NotBlank(message = "A descrição do quarto é obrigatória") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição do quarto é obrigatória") String descricao) {
        this.descricao = descricao;
    }
}
