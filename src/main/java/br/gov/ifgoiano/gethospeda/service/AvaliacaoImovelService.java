package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.AvaliacaoImovelController;
import br.gov.ifgoiano.gethospeda.controller.ImovelController;
import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.AvaliacaoImovelResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.AvaliacaoImovel;
import br.gov.ifgoiano.gethospeda.repository.AvaliacaoImovelRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AvaliacaoImovelService {
    @Autowired
    private AvaliacaoImovelRepository avaliacaoImovelRepository;

    private Logger logger = Logger.getLogger(AvaliacaoImovelService.class.getName());

    @Cacheable(value = "avaliacoesImoveis")
    public List<AvaliacaoImovelResumoDTO> findAll() {
        logger.info("findAll");
        List<AvaliacaoImovelResumoDTO> dtos = DataMapper.parseListObjects(avaliacaoImovelRepository.findAll(), AvaliacaoImovelResumoDTO.class);
        dtos.forEach(dto -> {
            dto.add(linkTo(methodOn(AvaliacaoImovelController.class).findById(dto.getId())).withSelfRel());
        });
        return dtos;
    }

    @Cacheable(value = "avaliacaoImovel", key = "#id")
    public AvaliacaoImovelCompletoDTO findById(Long id) {
        logger.info("findById");
        AvaliacaoImovel avaliacaoImovel = avaliacaoImovelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        AvaliacaoImovelCompletoDTO dto = DataMapper.parseObject(avaliacaoImovel, AvaliacaoImovelCompletoDTO.class);
        dto.add(linkTo(methodOn(ImovelController.class).findById(dto.getImovel().getId())).withSelfRel());
        return dto;
    }

    @Cacheable(value = "avaliacoesPorImovel", key = "#id")
    public List<AvaliacaoImovelResumoDTO> findByImovel(long id) {
        List<AvaliacaoImovel> avaliacaoImovels = avaliacaoImovelRepository.findByImovelId(id);
        return DataMapper.parseListObjects(avaliacaoImovels, AvaliacaoImovelResumoDTO.class);
    }

    @Caching(evict = {
            @CacheEvict(value = "avaliacoesImoveis", allEntries = true),
            @CacheEvict(value = "avaliacoesPorImovel", allEntries = true)
    })
    public AvaliacaoImovelCompletoDTO save(AvaliacaoImovelCreateDTO avaliacaoImovel) {
        logger.info("save");
        AvaliacaoImovel avaliacao = DataMapper.parseObject(avaliacaoImovel, AvaliacaoImovel.class);
        return DataMapper.parseObject(avaliacaoImovelRepository.save(avaliacao), AvaliacaoImovelCompletoDTO.class);
    }

    @Caching(evict = {
            @CacheEvict(value = "avaliacaoImovel", key = "#avaliacaoImovel.id"),
            @CacheEvict(value = "avaliacoesImoveis", allEntries = true),
            @CacheEvict(value = "avaliacoesPorImovel", allEntries = true)
    })
    public AvaliacaoImovelCompletoDTO update(AvaliacaoImovelCompletoDTO avaliacaoImovel) {
        logger.info("update");
        AvaliacaoImovel newAvaliacaoImovel = avaliacaoImovelRepository.findById(avaliacaoImovel.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        newAvaliacaoImovel.setNota(avaliacaoImovel.getNota());
        newAvaliacaoImovel.setComentario(avaliacaoImovel.getComentario());
        newAvaliacaoImovel.setDataAvaliacao(avaliacaoImovel.getDataAvaliacao());
        return DataMapper.parseObject(avaliacaoImovelRepository.save(newAvaliacaoImovel), AvaliacaoImovelCompletoDTO.class);
    }

    @Caching(evict = {
            @CacheEvict(value = "avaliacaoImovel", key = "#id"),
            @CacheEvict(value = "avaliacoesImoveis", allEntries = true),
            @CacheEvict(value = "avaliacoesPorImovel", allEntries = true)
    })
    public boolean delete(Long id) {
        logger.info("delete");
        if (avaliacaoImovelRepository.existsById(id)) {
            avaliacaoImovelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
