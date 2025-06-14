package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;


public class QuartoCompletoDTO extends RepresentationModel<QuartoCompletoDTO> {

    @Schema(description = "Identificador único do quarto", example = "10")
    private long id;

    @Schema(description = "Tipo do quarto", example = "Suíte")
    private String tipo;

    @Schema(description = "Quantidade de camas no quarto", example = "2")
    private int quantidadeCamas;

    @Schema(description = "Indica se o quarto possui banheiro privativo", example = "true")
    private boolean banheiroPrivativo;

    @Schema(description = "Área do quarto em metros quadrados", example = "25.5")
    private double areaM2;

    @Schema(description = "Resumo do imóvel ao qual o quarto pertence")
    private ImovelResumoDTO imovel;

    @Schema(description = "Descrição detalhada do quarto", example = "Quarto amplo com vista para o jardim")
    private String descricao;


    public QuartoCompletoDTO() {
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

    @Schema(hidden = true)  // oculta no Swagger UI
    // opcional: oculta no JSON (se quiser)
    public Links getLinks() {
        return super.getLinks();
    }
}
