package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.model.SolicitaServicoId;
import br.gov.ifgoiano.gethospeda.repository.SolicitaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitaServicoService {

    @Autowired
    private SolicitaServicoRepository repository;

    public SolicitaServicoService(SolicitaServicoRepository repository) {
        this.repository = repository;
    }

    public List<SolicitaServico> findAll() {
        return repository.findAll();
    }

    public SolicitaServico save(SolicitaServico solicitacao) {
        SolicitaServicoId id = solicitacao.getId();

        boolean existe = repository.existsById(id);

        if (!existe) {
            return repository.save(solicitacao);
        }
        return null;
    }


    public void delete(SolicitaServico solicitacao) {
        repository.delete(solicitacao);
    }
}