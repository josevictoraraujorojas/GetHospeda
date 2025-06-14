package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class ServicoDTO extends RepresentationModel<ServicoDTO> implements Serializable {

    @Schema(description = "Id que identifica o serviço", example = "1")
    private long id;

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

    public ServicoDTO() {
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
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
        ServicoDTO that = (ServicoDTO) o;
        return id == that.id && Double.compare(preco, that.preco) == 0 && disponibilidade == that.disponibilidade && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(imovel, that.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, disponibilidade, imovel);
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }
}
