package br.gov.ifgoiano.gethospeda.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Schema(name = "ReservaCompletoDTO", description = "Representação completa de uma reserva")
public class ReservaCompletoDTO extends RepresentationModel<ReservaCompletoDTO> {

    @Schema(description = "ID da reserva", example = "101")
    private Long id;

    @Schema(description = "Data de início da reserva", example = "2025-06-20T14:00:00Z")
    private Date dataInicio;

    @Schema(description = "Data de término da reserva", example = "2025-06-25T11:00:00Z")
    private Date dataFim;

    @Schema(description = "Data em que a reserva foi realizada", example = "2025-06-14T08:30:00Z")
    private Date reserva;

    @Schema(description = "Valor total da reserva", example = "750.00")
    private double valorTotal;

    @Schema(description = "Status atual da reserva", example = "CONFIRMADA")
    private String status;

    @Schema(description = "Informações resumidas do quarto reservado")
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

    @Schema(hidden = true)
    public Links getLinks() {
        return super.getLinks();
    }
}
