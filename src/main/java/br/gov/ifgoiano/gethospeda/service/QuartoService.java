package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.QuartoCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.QuartoResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Quarto;
import br.gov.ifgoiano.gethospeda.repository.QuartoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;
    Logger logger = Logger.getLogger(QuartoService.class.getName());

    public List<QuartoResumoDTO> findAll() {
        logger.info("findAll");
        List<Quarto> quartos = quartoRepository.findAll();
        return DataMapper.parseListObjects(quartos, QuartoResumoDTO.class);
    }

    public QuartoCompletoDTO findById(Long id) {
        logger.info("findById");
        Quarto quarto = quartoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(quarto, QuartoCompletoDTO.class);
    }

    public QuartoCompletoDTO save(QuartoCreateDTO quarto) {
        logger.info("save");
        return DataMapper.parseObject(quartoRepository.save(DataMapper.parseObject(quarto,Quarto.class)),QuartoCompletoDTO.class);
    }

    public QuartoCompletoDTO update(QuartoCompletoDTO quarto) {
        logger.info("update");
        Quarto newQuarto = quartoRepository.findById(quarto.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        newQuarto.setTipo(quarto.getTipo());
        newQuarto.setQuantidadeCamas(quarto.getQuantidadeCamas());
        newQuarto.setBanheiroPrivativo(quarto.isBanheiroPrivativo());
        newQuarto.setAreaM2(quarto.getAreaM2());
        newQuarto.setDescricao(quarto.getDescricao());
        return  DataMapper.parseObject(quartoRepository.save(newQuarto),QuartoCompletoDTO.class);
    }
    public void deleteById(Long id) {
        logger.info("deleteById");
        quartoRepository.deleteById(id);
    }
}
