package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitaServicoRepository extends JpaRepository<SolicitaServico, SolicitaServicoId> {
    boolean existsByReservaAndServico(Reserva reserva, Servico servico);
}