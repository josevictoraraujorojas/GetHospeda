package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(description = "DTO completo de uma avaliação de imóvel, incluindo informações do imóvel e data da avaliação.")
public class AvaliacaoImovelCompletoDTO extends RepresentationModel<AvaliacaoImovelResumoDTO> {

    @Schema(description = "ID da avaliação", example = "1")
    private long id;

    @Schema(description = "Nota atribuída na avaliação (de 1 a 5)", example = "4")
    private int nota;

    @Schema(description = "Comentário feito na avaliação", example = "Ótima experiência no imóvel.")
    private String comentario;

    @Schema(
            description = "Data da avaliação no formato ISO 8601 (ex: 2025-06-14T10:30:00Z).",
            example = "2025-06-14T10:30:00Z",
            type = "string",
            format = "date-time"
    )
    private Date dataAvaliacao;

    @Schema(description = "Resumo do imóvel avaliado")
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

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    @Schema(hidden = true) // oculta no Swagger UI
    public Links getLinks() {
        return super.getLinks();
    }
}
