package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

public class AvaliacaoImovelCompletoDTO extends RepresentationModel<AvaliacaoImovelResumoDTO> {
    private long id;
    private int nota;
    private String comentario;
    private Double dataAvaliacao;
    private ImovelResumoDTO imovel;

    public AvaliacaoImovelCompletoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Double dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
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
