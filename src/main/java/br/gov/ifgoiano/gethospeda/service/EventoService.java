package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.ImovelController;
import br.gov.ifgoiano.gethospeda.dto.EventoDTO;
import br.gov.ifgoiano.gethospeda.dto.EventoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.EventoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<EventoDTOOutput> findAll() {

        var eventos = repository.findAll();
        var eventosDto = DataMapper.parseListObjects(eventos, EventoDTOOutput.class);
        eventosDto
                .stream()
                .forEach(p ->
                        p.add(linkTo(methodOn(ImovelController.class).findById(p.getImovel().getId())).withSelfRel()));
        return eventosDto;
    }

    @Cacheable(value = "eventos", key = "#id")
    public EventoDTOOutput findById(Long id) {
        var eventoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        // Aqui garantimos que o objeto é Evento para o ModelMapper
        EventoDTOOutput vo = DataMapper.parseObject(eventoEntity, EventoDTOOutput.class);
        vo.add(linkTo(methodOn(ImovelController.class).findById(eventoEntity.getImovel().getId())).withSelfRel());
        return vo;
    }

    public EventoDTO save(EventoDTO eventoDTO) {
        var eventoEntity = DataMapper.parseObject(eventoDTO, br.gov.ifgoiano.gethospeda.model.Evento.class);

        var eventoSaved = repository.save(eventoEntity);
        var vo = DataMapper.parseObject(eventoSaved, EventoDTO.class);

        vo.add(linkTo(methodOn(ImovelController.class).findById(vo.getImovel().getId())).withSelfRel());
        return vo;
    }

    @CachePut(value = "eventos", key = "#eventoDTO.id")
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
        var vo = DataMapper.parseObject(entity, EventoDTO.class);
        vo.add(linkTo(methodOn(ImovelController.class).findById(vo.getImovel().getId())).withSelfRel());
        return vo;
    }

    @CacheEvict(value = "eventos", key = "#id")
    public void delete(Long id) {
        var eventoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(eventoEntity);
    }
}
