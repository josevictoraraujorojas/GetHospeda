package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.model.CadastraEventoId;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastraEventoRepository extends JpaRepository<CadastraEvento, CadastraEventoId> {
    boolean existsByHospedeAndEvento(Hospede hospede, Evento evento);
}