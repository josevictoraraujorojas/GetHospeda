package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.Reserva;
import br.gov.ifgoiano.gethospeda.model.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByQuartoId(Long quartoId);

    List<Reserva> findByQuartoIdAndStatus(Long quartoId, StatusReserva status);

    @Query("SELECT r FROM Reserva r WHERE r.quarto.id = :quartoId AND NOT (:novaFim < r.dataInicio OR :novaInicio > r.dataFim)")
    List<Reserva> findReservasConflitantes(@Param("quartoId") Long quartoId,
                                           @Param("novaInicio") Date novaInicio,
                                           @Param("novaFim") Date novaFim);
}
