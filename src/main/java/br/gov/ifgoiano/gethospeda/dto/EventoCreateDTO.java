package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.Date;

public class EventoCreateDTO {

    @Schema(description = "Nome do evento", example = "Festa Junina")
    @NotBlank(message = "O nome do evento é obrigatório.")
    private String nome;

    @Schema(description = "Local que o evento vai ocorrer", example = "Quadra Coberta")
    @NotBlank(message = "O local do evento é obrigatório.")
    private String local;

    @Schema(description = "Descrição do evento", example = "Festividade do mês de junho")
    @NotBlank(message = "A descrição do evento é obrigatória.")
    private String descricao;

    @Schema(description = "Data que se inicia o evento", example = "2025-12-01T10:00:00Z")
    @NotNull(message = "A data de início é obrigatória.")
    @FutureOrPresent(message = "A data de início deve ser no presente ou no futuro.")
    private Date dataInicio;

    @Schema(description = "Data que termina o evento", example = "2025-12-03T10:00:00Z")
    @NotNull(message = "A data de fim é obrigatória.")
    @Future(message = "A data de fim deve ser no futuro.")
    private Date dataFim;

    @Schema(description = "Capacidade máxima do evento", example = "40")
    @Min(value = 1, message = "A capacidade mínima do evento deve ser de pelo menos 1.")
    private int capacidade;

    @Schema(description = "Id do imóvel que o evento está ligado", example = "1")
    @NotNull(message = "O imóvel associado é obrigatório.")
    private ImovelResumoDTO imovel;

    public EventoCreateDTO() {
    }



    public @NotBlank(message = "O nome do evento é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome do evento é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O local do evento é obrigatório.") String getLocal() {
        return local;
    }

    public void setLocal(@NotBlank(message = "O local do evento é obrigatório.") String local) {
        this.local = local;
    }

    public @NotBlank(message = "A descrição do evento é obrigatória.") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição do evento é obrigatória.") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "A data de início é obrigatória.") @FutureOrPresent(message = "A data de início deve ser no presente ou no futuro.") Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NotNull(message = "A data de início é obrigatória.") @FutureOrPresent(message = "A data de início deve ser no presente ou no futuro.") Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public @NotNull(message = "A data de fim é obrigatória.") @Future(message = "A data de fim deve ser no futuro.") Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(@NotNull(message = "A data de fim é obrigatória.") @Future(message = "A data de fim deve ser no futuro.") Date dataFim) {
        this.dataFim = dataFim;
    }

    @Min(value = 1, message = "A capacidade mínima do evento deve ser de pelo menos 1.")
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(@Min(value = 1, message = "A capacidade mínima do evento deve ser de pelo menos 1.") int capacidade) {
        this.capacidade = capacidade;
    }

    public @NotNull(message = "O imóvel associado é obrigatório.") ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(@NotNull(message = "O imóvel associado é obrigatório.") ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }
}
