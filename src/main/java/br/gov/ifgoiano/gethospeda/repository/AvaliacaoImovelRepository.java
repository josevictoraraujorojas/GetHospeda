package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.AvaliacaoImovel;
import br.gov.ifgoiano.gethospeda.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoImovelRepository extends JpaRepository<AvaliacaoImovel, Long> {
    List<AvaliacaoImovel> findByImovelId(long Imovelid);
}
