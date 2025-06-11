package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class EventoDTO extends RepresentationModel<EventoDTO> implements Serializable {

    @Schema(description = "Identificador único do evento", example = "1")
    private long id;

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

    public EventoDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventoDTO eventoDTO = (EventoDTO) o;
        return id == eventoDTO.id && capacidade == eventoDTO.capacidade && Objects.equals(nome, eventoDTO.nome) && Objects.equals(local, eventoDTO.local) && Objects.equals(descricao, eventoDTO.descricao) && Objects.equals(dataInicio, eventoDTO.dataInicio) && Objects.equals(dataFim, eventoDTO.dataFim) && Objects.equals(imovel, eventoDTO.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, local, descricao, dataInicio, dataFim, capacidade, imovel);
    }
}
