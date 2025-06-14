package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

@Schema(name = "ServicoResumoDTO", description = "Resumo das informações de um serviço oferecido por uma hospedagem")
public class ServicoResumoDTO extends RepresentationModel<ServicoResumoDTO> {

    @Schema(description = "Identificador único do serviço", example = "1")
    private long id;

    @Schema(description = "Nome do serviço", example = "Café da manhã")
    private String nome;

    @Schema(description = "Preço do serviço em reais", example = "29.90")
    private double preco;

    @Schema(description = "Indica se o serviço está disponível", example = "true")
    private boolean disponibilidade;

    public ServicoResumoDTO() {}

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

    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
