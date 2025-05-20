package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.repository.CadastraEventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastraEventoService {
    private final CadastraEventoRepository repository;

    public CadastraEventoService(CadastraEventoRepository repository) {
        this.repository = repository;
    }

    public List<CadastraEvento> findAll() {
        return repository.findAll();
    }

    public CadastraEvento save(CadastraEvento cadastro) {
        return repository.save(cadastro);
    }

    public void delete(CadastraEvento cadastro) {
        repository.delete(cadastro);
    }
}