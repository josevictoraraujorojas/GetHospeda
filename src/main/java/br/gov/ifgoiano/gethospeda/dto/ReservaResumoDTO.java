package br.gov.ifgoiano.gethospeda.dto;

import java.util.Date;

public class ReservaResumoDTO {
    private long id;
    private Date reserva;
    private double valorTotal;

    public ReservaResumoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
