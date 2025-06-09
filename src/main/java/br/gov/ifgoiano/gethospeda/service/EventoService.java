package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.EventoDTO;
import br.gov.ifgoiano.gethospeda.dto.EventoDTOOutput;
import br.gov.ifgoiano.gethospeda.dto.EventoResumoDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.model.Servico;
import br.gov.ifgoiano.gethospeda.repository.EventoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<EventoDTOOutput> findAll() {
        var eventos = repository.findAll();
        return DataMapper.parseListObjects(eventos, EventoDTOOutput.class);
    }

    public EventoDTOOutput findById(Long id) {
        var eventoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        // Aqui garantimos que o objeto é Evento para o ModelMapper
        return DataMapper.parseObject(eventoEntity, EventoDTOOutput.class);
    }

    public List<EventoResumoDTO> findByImovel(long id) {
        List<Evento> eventos = repository.findByImovelId(id);
        return DataMapper.parseListObjects(eventos, EventoResumoDTO.class);
    }

    public EventoDTO save(EventoDTO eventoDTO) {
        var eventoEntity = DataMapper.parseObject(eventoDTO, br.gov.ifgoiano.gethospeda.model.Evento.class);

        var eventoSaved = repository.save(eventoEntity);
        return DataMapper.parseObject(eventoSaved, EventoDTO.class);
    }

    public EventoDTO update(EventoDTO eventoDTO) {
        var entity = repository.findById(eventoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Atualiza campos manualmente para evitar erros
        entity.setNome(eventoDTO.getNome());
        entity.setDescricao(eventoDTO.getDescricao());
        entity.setLocal(eventoDTO.getLocal());
        entity.setDataInicio(eventoDTO.getDataInicio());
        entity.setDataFim(eventoDTO.getDataFim());
        entity.setCapacidade(eventoDTO.getCapacidade());

        Imovel imovel = new Imovel();
        imovel.setId(eventoDTO.getImovel().getId());
        entity.setImovel(imovel);

        var updated = repository.save(entity);
        return DataMapper.parseObject(updated, EventoDTO.class);
    }

    public void delete(Long id) {
        var eventoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(eventoEntity);
    }
}
