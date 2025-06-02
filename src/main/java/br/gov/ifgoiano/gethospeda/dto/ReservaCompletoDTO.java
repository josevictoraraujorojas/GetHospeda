package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class ReservaCompletoDTO {
    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private Date reserva;
    private double valorTotal;
    private String status;
    private QuartoResumoDTO quarto;

    public ReservaCompletoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getReserva() {
        return reserva;
    }

    public void setReserva(Date reserva) {
        this.reserva = reserva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuartoResumoDTO getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoResumoDTO quarto) {
        this.quarto = quarto;
    }
}
