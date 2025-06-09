package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.*;
import br.gov.ifgoiano.gethospeda.dto.*;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.ImovelRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private QuartoService quartoService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private AvaliacaoImovelService avaliacaoImovelService;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public List<ImovelResumoDTO> findAll() {
        logger.info("findAll");
        List<Imovel> imoveis = imovelRepository.findAll();
        return DataMapper.parseListObjects(imoveis, ImovelResumoDTO.class);
    }

    public List<QuartoResumoDTO> quartoFindByImovel(long id) {
       imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
       List<QuartoResumoDTO> quartoResumoDTOS = quartoService.findByImovel(id);
       quartoResumoDTOS.forEach(quartoResumoDTO -> {
          quartoResumoDTO.add(linkTo(methodOn(QuartoController.class).findById(quartoResumoDTO.getId())).withSelfRel());
       });
       return quartoResumoDTOS;
    }

    public List<AreaResumoDTO> areaFindByImovel(long id) {
        imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        List<AreaResumoDTO> areaResumoDTOS = areaService.findByImovel(id);
        areaResumoDTOS.forEach(areaResumoDTO -> {
           areaResumoDTO.add(linkTo(methodOn(AreaController.class).findById(areaResumoDTO.getId())).withSelfRel());
        });
        return areaResumoDTOS;
    }

    public List<ServicoResumoDTO> servicoFindByImovel(long id) {
        imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        List<ServicoResumoDTO> servicoResumoDTOS = servicoService.findByImovel(id);
        servicoResumoDTOS.forEach(servicoResumoDTO -> {
            servicoResumoDTO.add(linkTo(methodOn(ServicoController.class).buscarPorId(servicoResumoDTO.getId())).withSelfRel());
        });
        return servicoResumoDTOS;
    }

    public List<EventoResumoDTO> eventoFindByImovel(long id) {
        imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        List<EventoResumoDTO> eventoResumoDTOS= eventoService.findByImovel(id);
        eventoResumoDTOS.forEach(eventoResumoDTO -> {
            eventoResumoDTO.add(linkTo(methodOn(EventoController.class).buscarPorId(eventoResumoDTO.getId())).withSelfRel());
        });
        return eventoResumoDTOS;
    }

    public List<AvaliacaoImovelResumoDTO> avaliacaoFindByImovel(long id) {
        imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        List<AvaliacaoImovelResumoDTO> avaliacaoImovelResumoDTOS = avaliacaoImovelService.findByImovel(id);
        avaliacaoImovelResumoDTOS.forEach(avaliacaoImovelResumoDTO -> {
            avaliacaoImovelResumoDTO.add(linkTo(methodOn(AvaliacaoImovelController.class).getAvaliacaoImovel(avaliacaoImovelResumoDTO.getId())).withSelfRel());
        });
        return avaliacaoImovelResumoDTOS;
    }


    public ImovelCompletoDTO findById(Long id) {
        logger.info("findById");
        Imovel imovel = imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(imovel, ImovelCompletoDTO.class);
    }

    public ImovelCompletoDTO save(ImovelCreateDTO imovel) {
        logger.info("save");
        return DataMapper.parseObject(imovelRepository.save(DataMapper.parseObject(imovel,Imovel.class)),ImovelCompletoDTO.class);
    }

    public ImovelCompletoDTO update(ImovelCompletoDTO imovel) {
        logger.info("update");
        Imovel entity = imovelRepository.findById(imovel.getId()).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        entity.setTitulo(imovel.getTitulo());
        entity.setDescricao(imovel.getDescricao());
        entity.setEndereco(imovel.getEndereco());
        entity.setCidade(imovel.getCidade());
        entity.setEstado(imovel.getEstado());
        entity.setCep(imovel.getCep());
        entity.setPrecoDiaria(imovel.getPrecoDiaria());
        entity.setPoliticaDeCancelamento(imovel.getPoliticaDeCancelamento());
        entity.setStatus(imovel.getStatus());
        return DataMapper.parseObject(imovelRepository.save(entity), ImovelCompletoDTO.class);
    }

    public void delete(Long id) {
        logger.info("delete");
        imovelRepository.deleteById(id);
    }


}
