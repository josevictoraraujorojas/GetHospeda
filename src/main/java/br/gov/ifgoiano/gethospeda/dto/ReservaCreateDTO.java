package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Schema(name = "ReservaCreateDTO", description = "Dados necessários para criar uma nova reserva")
public class ReservaCreateDTO {

    @NotNull
    @Schema(description = "Data de início da reserva", example = "2025-07-01T14:00:00Z", required = true)
    private Date dataInicio;

    @NotNull
    @Schema(description = "Data de termino da reserva", example = "2025-09-01T14:00:00Z", required = true)
    private Date dataFim;

    @NotNull
    @Schema(description = "Data em que a reserva foi realizada", example = "2025-06-14T08:30:00Z", required = true)
    private Date reserva;

    @NotNull
    @Schema(description = "Quarto selecionado para a reserva", required = true)
    private QuartoResumoDTO quarto;

    @NotNull
    @Schema(description = "Hóspede que está realizando a reserva", required = true)
    private HospedeResumoDTO hospede;

    public ReservaCreateDTO() {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getReserva() {
        return reserva;
    }

    public void setReserva(Date reserva) {
        this.reserva = reserva;
    }

    public QuartoResumoDTO getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoResumoDTO quarto) {
        this.quarto = quarto;
    }

    public HospedeResumoDTO getHospede() {
        return hospede;
    }

    public void setHospede(HospedeResumoDTO hospede) {
        this.hospede = hospede;
    }

    public @NotNull Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(@NotNull Date dataFim) {
        this.dataFim = dataFim;
    }
}
