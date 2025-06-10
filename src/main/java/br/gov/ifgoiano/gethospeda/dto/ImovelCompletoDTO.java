package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Schema(description = "Representa os dados completos de um imóvel")
public class ImovelCompletoDTO extends RepresentationModel<ImovelCompletoDTO> implements Serializable {

    @Schema(description = "Identificador único do imóvel", example = "1")
    private long id;

    @Schema(description = "Título do imóvel", example = "Casa de Campo com Lareira")
    private String titulo;

    @Schema(description = "Descrição detalhada do imóvel", example = "Casa aconchegante no campo com lareira, 2 quartos e varanda.")
    private String descricao;

    @Schema(description = "Endereço completo do imóvel", example = "Chácara Vista Alegre, KM 12")
    private String endereco;

    @Schema(description = "Cidade onde o imóvel está localizado", example = "Goiânia")
    private String cidade;

    @Schema(description = "Estado (UF) do imóvel", example = "GO")
    private String estado;

    @Schema(description = "CEP do imóvel (apenas números)", example = "74600000")
    private String cep;

    @Schema(description = "Preço da diária em reais", example = "150.00", minimum = "1")
    private float precoDiaria;

    @Schema(description = "Política de cancelamento do imóvel", example = "Cancelamento gratuito até 3 dias antes do check-in.")
    private String politicaDeCancelamento;

    @Schema(description = "Status atual do imóvel", example = "DISPONIVEL")
    private String status;

    @Schema(description = "Informações do proprietário associado ao imóvel")
    private ProprietarioResumoDTO proprietario;

    public ImovelCompletoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProprietarioResumoDTO getProprietario() {
        return proprietario;
    }

    public void setProprietario(ProprietarioResumoDTO proprietario) {
        this.proprietario = proprietario;
    }

    @Schema(hidden = true)  // oculta no Swagger UI
    // opcional: oculta no JSON (se quiser)
    public Links getLinks() {
        return super.getLinks();
    }
}
