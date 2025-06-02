package br.gov.ifgoiano.gethospeda.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ReservaCreateDTO {
    @NotNull
    private Date dataInicio;
    @NotNull
    private Date reserva;
    @NotNull
    private QuartoResumoDTO quarto;

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
}
