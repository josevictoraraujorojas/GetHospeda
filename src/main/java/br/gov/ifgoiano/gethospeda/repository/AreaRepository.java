package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.Area;
import br.gov.ifgoiano.gethospeda.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByImovelId(long Imovelid);
}
