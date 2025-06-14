package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.ImovelController;
import br.gov.ifgoiano.gethospeda.dto.EventoDTOOutput;
import br.gov.ifgoiano.gethospeda.dto.ServicoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.model.Servico;
import br.gov.ifgoiano.gethospeda.repository.ServicoRepository;
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
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<ServicoDTOOutput> findAll() {
        var servicos = repository.findAll();
        var servicosDto = DataMapper.parseListObjects(servicos, ServicoDTOOutput.class);
        servicosDto
                .stream()
                .forEach(p ->
                        p.add(linkTo(methodOn(ImovelController.class).findById(p.getImovel().getId())).withSelfRel()));
        return servicosDto;
    }

    @Cacheable(value = "servicos", key = "#id")
    public ServicoDTOOutput findById(Long id) {
        var servicoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        // Aqui garantimos que o objeto é Evento para o ModelMapper
        ServicoDTOOutput vo = DataMapper.parseObject(servicoEntity, ServicoDTOOutput.class);
        vo.add(linkTo(methodOn(ImovelController.class).findById(servicoEntity.getImovel().getId())).withSelfRel());
        return vo;
    }

    @Cacheable(value = "servicos", key = "#imovelId")
    public List<ServicoDTOOutput> findByImovelId(long imovelId) {

        var servicos = repository.findByImovelId(imovelId);
        if (servicos.isEmpty()) {
            throw new ResourceNotFoundException("Sem serviços marcados para esse imóvel!");
        }

        var servicosDto = DataMapper.parseListObjects(servicos, ServicoDTOOutput.class);
        servicosDto.forEach(e ->
                e.add(linkTo(methodOn(ImovelController.class).findById(e.getImovel().getId())).withSelfRel())
        );
        return servicosDto;
    }

    public ServicoDTO save(ServicoCreateDTO servicoDTO) {
        var servicoEntity = DataMapper.parseObject(servicoDTO, br.gov.ifgoiano.gethospeda.model.Servico.class);

        var servicoSaved = repository.save(servicoEntity);
        var vo = DataMapper.parseObject(servicoSaved, ServicoDTO.class);

        vo.add(linkTo(methodOn(ImovelController.class).findById(vo.getImovel().getId())).withSelfRel());
        return vo;
    }

    @CachePut(value = "servicos", key = "#servicoDTO.id")
    public ServicoDTO update(ServicoDTO servicoDTO) {
        var entity = repository.findById(servicoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Atualiza campos manualmente para evitar erros
        entity.setNome(servicoDTO.getNome());
        entity.setDescricao(servicoDTO.getDescricao());
        entity.setPreco(servicoDTO.getPreco());
        entity.setDisponibilidade(servicoDTO.isDisponibilidade());

        Imovel imovel = new Imovel();
        imovel.setId(servicoDTO.getImovel().getId());
        entity.setImovel(imovel);

        var updated = repository.save(entity);
        var vo = DataMapper.parseObject(entity, ServicoDTO.class);
        vo.add(linkTo(methodOn(ImovelController.class).findById(vo.getImovel().getId())).withSelfRel());
        return vo;
    }

    @CacheEvict(value = "servicos", key = "#id")
    public void delete(Long id) {
        var servicoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(servicoEntity);
    }
}