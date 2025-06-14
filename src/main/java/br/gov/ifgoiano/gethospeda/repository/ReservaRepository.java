package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByQuartoId(Long quartoId);

    List<Reserva> findByQuartoIdAndStatus(Long quartoId, String status);
}
