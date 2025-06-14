package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Schema(description = "DTO utilizado para criação de uma nova avaliação de imóvel.")
public class AvaliacaoImovelCreateDTO {

    @Schema(description = "Nota da avaliação (de 1 a 5).", example = "4", required = true)
    @NotNull
    private int nota;

    @Schema(description = "Comentário feito pelo hóspede sobre o imóvel.", example = "Excelente estadia!", required = true)
    @NotBlank
    private String comentario;

    @Schema(
            description = "Data da avaliação no formato ISO 8601 (ex: 2025-06-14T10:30:00Z).",
            example = "2025-06-14T10:30:00Z",
            required = true,
            type = "string",
            format = "date-time"
    )
    @NotNull
    private Date dataAvaliacao;


    @Schema(description = "Resumo do imóvel avaliado.", required = true)
    @NotNull
    private ImovelResumoDTO imovel;

    @Schema(description = "Resumo do hóspede que fez a avaliação.", required = true)
    @NotNull
    private HospedeResumoDTO hospede;

    public AvaliacaoImovelCreateDTO() {
    }

    @NotNull
    public int getNota() {
        return nota;
    }

    public void setNota(@NotNull int nota) {
        this.nota = nota;
    }

    public @NotBlank String getComentario() {
        return comentario;
    }

    public void setComentario(@NotBlank String comentario) {
        this.comentario = comentario;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public @NotNull ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(@NotNull ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    public @NotNull HospedeResumoDTO getHospede() {
        return hospede;
    }

    public void setHospede(@NotNull HospedeResumoDTO hospede) {
        this.hospede = hospede;
    }
}
