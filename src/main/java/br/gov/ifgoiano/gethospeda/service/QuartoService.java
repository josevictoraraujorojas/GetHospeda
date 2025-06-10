package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.ImovelController;
import br.gov.ifgoiano.gethospeda.controller.QuartoController;
import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoResumoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoUpdateDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Quarto;
import br.gov.ifgoiano.gethospeda.repository.QuartoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;
    Logger logger = Logger.getLogger(QuartoService.class.getName());

    public List<QuartoResumoDTO> findAll() {
        logger.info("findAll");
        List<Quarto> quartos = quartoRepository.findAll();
        List<QuartoResumoDTO> quartoResumoDTOS = DataMapper.parseListObjects(quartos, QuartoResumoDTO.class);
        quartoResumoDTOS.forEach(quartoResumoDTO -> {
            quartoResumoDTO.add(linkTo(methodOn(QuartoController.class).findById(quartoResumoDTO.getId())).withSelfRel());
        });
        return quartoResumoDTOS;
    }

    public List<QuartoResumoDTO> findByImovel(long id) {
        logger.info("findByImovel");
        List<Quarto> quartos = quartoRepository.findByImovelId(id);
        return DataMapper.parseListObjects(quartos, QuartoResumoDTO.class);
    }


    public QuartoCompletoDTO findById(Long id) {
        logger.info("findById");
        Quarto quarto = quartoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        QuartoCompletoDTO quartoCompletoDTO =  DataMapper.parseObject(quarto, QuartoCompletoDTO.class);
        quartoCompletoDTO.getImovel().add(linkTo(methodOn(ImovelController.class).findById(quartoCompletoDTO.getImovel().getId())).withSelfRel());
        return quartoCompletoDTO;
    }

    public QuartoCompletoDTO save(QuartoCreateDTO quarto) {
        logger.info("save");
        return DataMapper.parseObject(quartoRepository.save(DataMapper.parseObject(quarto,Quarto.class)),QuartoCompletoDTO.class);
    }

    public QuartoCompletoDTO update(QuartoUpdateDTO quarto) {
        logger.info("update");
        Quarto newQuarto = quartoRepository.findById(quarto.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        newQuarto.setTipo(quarto.getTipo());
        newQuarto.setQuantidadeCamas(quarto.getQuantidadeCamas());
        newQuarto.setBanheiroPrivativo(quarto.isBanheiroPrivativo());
        newQuarto.setAreaM2(quarto.getAreaM2());
        newQuarto.setDescricao(quarto.getDescricao());
        return  DataMapper.parseObject(quartoRepository.save(newQuarto),QuartoCompletoDTO.class);
    }
    public boolean deleteById(Long id) {
        logger.info("deleteById");
        if (quartoRepository.findById(id).isPresent()) {
        quartoRepository.deleteById(id);
        return true;
        }else {
            return false;
        }
    }
}
