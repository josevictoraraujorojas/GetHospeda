package br.gov.ifgoiano.gethospeda.dto;

import br.gov.ifgoiano.gethospeda.model.StatusReserva;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(name = "ReservaResumoDTO", description = "Informações resumidas de uma reserva")
public class ReservaResumoDTO extends RepresentationModel<ReservaResumoDTO> {

    @Schema(description = "Identificador único da reserva", example = "101")
    private long id;

    @Schema(description = "Data em que a reserva foi realizada", example = "2025-06-14T09:00:00Z")
    private Date reserva;

    @Schema(description = "Valor total da reserva", example = "450.75")
    private double valorTotal;

    @Schema(description = "Status atual da reserva", example = "CONFIRMADA")
    private StatusReserva status;

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

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
