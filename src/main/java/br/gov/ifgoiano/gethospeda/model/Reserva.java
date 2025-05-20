package br.gov.ifgoiano.gethospeda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private Date reserva;
    private double valorTotal;
    private String status;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "hospede_id",referencedColumnName = "id")
    @JsonBackReference
    private Hospede hospede;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "quarto_id",referencedColumnName = "id")
    @JsonBackReference
    private Quarto quarto;

    public Reserva() {
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

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
