package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByImovelId(long Imovelid);
}