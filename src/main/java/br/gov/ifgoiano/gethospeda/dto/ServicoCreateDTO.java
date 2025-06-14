package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ServicoCreateDTO {

    @Schema(description = "Nome do serviço", example = "Serviço de limpeza")
    @NotBlank(message = "O nome do serviço é obrigatório.")
    private String nome;

    @Schema(description = "Descrição do serviço", example = "Limpeza do imóvel")
    @NotBlank(message = "A descrição do serviço é obrigatória.")
    private String descricao;

    @Schema(description = "Preço do serviço", example = "500.00")
    @Positive(message = "O preço deve ser maior que zero.")
    private double preco;

    @Schema(description = "Disponibilidade do serviço", example = "True")
    private boolean disponibilidade;

    @Schema(description = "Id do imóvel", example = "1")
    @NotNull(message = "O imóvel associado é obrigatório.")
    private ImovelResumoDTO imovel;

    public ServicoCreateDTO() {
    }

    public @NotBlank(message = "O nome do serviço é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome do serviço é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A descrição do serviço é obrigatória.") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição do serviço é obrigatória.") String descricao) {
        this.descricao = descricao;
    }

    @Positive(message = "O preço deve ser maior que zero.")
    public double getPreco() {
        return preco;
    }

    public void setPreco(@Positive(message = "O preço deve ser maior que zero.") double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public @NotNull(message = "O imóvel associado é obrigatório.") ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(@NotNull(message = "O imóvel associado é obrigatório.") ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }
}
