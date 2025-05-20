package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.repository.SolicitaServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitaServicoService {
    private final SolicitaServicoRepository repository;

    public SolicitaServicoService(SolicitaServicoRepository repository) {
        this.repository = repository;
    }

    public List<SolicitaServico> findAll() {
        return repository.findAll();
    }

    public SolicitaServico save(SolicitaServico solicitacao) {
        return repository.save(solicitacao);
    }

    public void delete(SolicitaServico solicitacao) {
        repository.delete(solicitacao);
    }
}