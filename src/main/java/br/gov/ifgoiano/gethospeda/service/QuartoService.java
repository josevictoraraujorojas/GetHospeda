package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Quarto;
import br.gov.ifgoiano.gethospeda.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Logger;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;
    Logger logger = Logger.getLogger(QuartoService.class.getName());

    public List<Quarto> findAll() {
        logger.info("findAll");
        return quartoRepository.findAll();
    }

    public Quarto findById(Long id) {
        logger.info("findById");
        return quartoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Quarto save(Quarto quarto) {
        logger.info("save");
        return quartoRepository.save(quarto);
    }

    public Quarto update(Quarto quarto) {
        logger.info("update");
        Quarto newQuarto = quartoRepository.findById(quarto.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        newQuarto.setTipo(quarto.getTipo());
        newQuarto.setQuantidadeCamas(quarto.getQuantidadeCamas());
        newQuarto.setBanheiroPrivativo(quarto.isBanheiroPrivativo());
        newQuarto.setAreaM2(quarto.getAreaM2());
        newQuarto.setDescricao(quarto.getDescricao());
        return quartoRepository.save(newQuarto);
    }
    public void deleteById(Long id) {
        logger.info("deleteById");
        quartoRepository.deleteById(id);
    }
}
