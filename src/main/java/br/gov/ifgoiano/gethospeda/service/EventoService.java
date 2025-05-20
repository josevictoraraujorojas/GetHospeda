package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<Evento> findAll() {
        return repository.findAll();
    }

    public Optional<Evento> findById(Long id) {
        return repository.findById(id);
    }

    public Evento save(Evento evento) {
        return repository.save(evento);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}