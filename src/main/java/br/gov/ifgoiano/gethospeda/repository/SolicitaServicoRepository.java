package br.gov.ifgoiano.gethospeda.repository;

import br.gov.ifgoiano.gethospeda.model.Hospede;
import br.gov.ifgoiano.gethospeda.model.Servico;
import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.model.SolicitaServicoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitaServicoRepository extends JpaRepository<SolicitaServico, SolicitaServicoId> {
    boolean existsByHospedeAndServico(Hospede hospede, Servico servico);
}