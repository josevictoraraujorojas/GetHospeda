package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "DTO para criação de um imóvel")
public class ImovelCreateDTO {

    @Schema(description = "Título do imóvel", example = "Casa de Praia")
    @NotBlank
    private String titulo;

    @Schema(description = "Descrição detalhada do imóvel", example = "Imóvel com vista para o mar, 3 quartos e piscina.")
    @NotBlank
    private String descricao;

    @Schema(description = "Endereço completo do imóvel", example = "Rua das Palmeiras, 123")
    @NotBlank
    private String endereco;

    @Schema(description = "Cidade onde o imóvel está localizado", example = "Salvador")
    @NotBlank
    private String cidade;

    @Schema(description = "Estado (UF) do imóvel", example = "BA")
    @NotBlank
    private String estado;

    @Schema(description = "CEP do imóvel (somente números, 8 dígitos)", example = "40010000")
    @Pattern(regexp = "^\\d{8}$")
    private String cep;

    @Schema(description = "Preço da diária em reais", example = "250.00", minimum = "1")
    @Min(1)
    private float precoDiaria;

    @Schema(description = "Política de cancelamento do imóvel", example = "Cancelamento gratuito até 7 dias antes do check-in.")
    @NotBlank
    private String politicaDeCancelamento;

    @Schema(description = "Resumo dos dados do proprietário associado ao imóvel")
    @NotNull
    private ProprietarioResumoDTO proprietarioResumo;

    public ImovelCreateDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public float getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(float precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public String getPoliticaDeCancelamento() {
        return politicaDeCancelamento;
    }

    public void setPoliticaDeCancelamento(String politicaDeCancelamento) {
        this.politicaDeCancelamento = politicaDeCancelamento;
    }

    public ProprietarioResumoDTO getProprietarioResumo() {
        return proprietarioResumo;
    }

    public void setProprietarioResumo(ProprietarioResumoDTO proprietarioResumo) {
        this.proprietarioResumo = proprietarioResumo;
    }
}
