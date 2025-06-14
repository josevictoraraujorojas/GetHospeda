package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.EventoController;
import br.gov.ifgoiano.gethospeda.dto.CadastraEventoDTO;
import br.gov.ifgoiano.gethospeda.dto.CadastraEventoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.CadastraEvento;
import br.gov.ifgoiano.gethospeda.model.CadastraEventoId;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.model.Hospede;
import br.gov.ifgoiano.gethospeda.repository.CadastraEventoRepository;
import br.gov.ifgoiano.gethospeda.repository.HospedeRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CadastraEventoService {

    @Autowired
    private CadastraEventoRepository repository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<CadastraEventoDTOOutput> findAll() {
        var cadastraEventos = repository.findAll();
        var eventoDto = DataMapper.parseListObjects(cadastraEventos, CadastraEventoDTOOutput.class);
        eventoDto
                .stream()
                .forEach(cadastraEventoDTOOutput ->
                        cadastraEventoDTOOutput.add(linkTo(methodOn(EventoController.class).buscarPorId(cadastraEventoDTOOutput.getEventoId())).withSelfRel()));
//        eventoDto
//                .stream()
//                .forEach(p ->
//                        p.add(linkTo(methodOn(HospedeController.class).buscarPorId(p.getHospedeId())).withSelfRel()));

        return eventoDto;
    }

    @Cacheable(value = "cadastraeventos", key = "#eventoId + '-' + #hospedeId")
    public CadastraEventoDTOOutput findById(Long eventoId, Long hospedeId) {
        CadastraEventoId id = new CadastraEventoId(eventoId, hospedeId);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        CadastraEventoDTOOutput vo = DataMapper.parseObject(entity, CadastraEventoDTOOutput.class);
        vo.add(linkTo(methodOn(EventoController.class).buscarPorId(entity.getEvento().getId())).withSelfRel());
//        vo.add(linkTo(methodOn(HospedeController.class).buscarPorId(entity.getHospede().getId())).withSelfRel());
        return vo;
    }

    public CadastraEventoDTO save(CadastraEventoDTO cadastro) {
        Hospede hospede = hospedeRepository.findById(cadastro.getHospedeId())
                .orElseThrow(() -> new ResourceNotFoundException("Hóspede não encontrado."));

        Evento evento = entityManager.getReference(Evento.class, cadastro.getEventoId());

        CadastraEvento entity = new CadastraEvento();
        entity.setEvento(evento);
        entity.setHospede(hospede);
        entity.setDataCadastro(cadastro.getDataCadastro());

        CadastraEvento saved = repository.save(entity);

        CadastraEventoDTO dto = DataMapper.parseObject(saved, CadastraEventoDTO.class);
        dto.add(linkTo(methodOn(EventoController.class).buscarPorId(saved.getEvento().getId())).withSelfRel());

//        dto.add(linkTo(methodOn(HospedeController.class).buscarPorId(eventoSaved.getHospede().getId())).withSelfRel());
        return dto;
    }

    @CachePut(value = "cadastraeventos", key = "#dto.eventoId")
    public CadastraEventoDTO update(CadastraEventoDTO dto) {
        CadastraEventoId id = new CadastraEventoId(dto.getEventoId(), dto.getHospedeId());

        CadastraEvento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro em evento não encontrada!"));

        entity.setDataCadastro(dto.getDataCadastro());
        repository.save(entity);

        var vo = DataMapper.parseObject(entity, CadastraEventoDTO.class);
        vo.add(linkTo(methodOn(EventoController.class).buscarPorId(entity.getEvento().getId())).withSelfRel());
//        vo.add(linkTo(methodOn(HospedeController.class).buscarPorId(entity.getHospede().getId())).withSelfRel());

        return vo;
    }

    @CacheEvict(value = "cadastraeventos", key = "#cadastraEventoDTO.eventoId")
    public void delete(CadastraEventoDTO cadastraEventoDTO) {
        CadastraEventoId id = new CadastraEventoId(cadastraEventoDTO.getEventoId(), cadastraEventoDTO.getHospedeId());

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro em evento não encontrada!"));

        repository.delete(entity);
    }
}